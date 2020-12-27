package com.apoorva.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.apoorva.demo.domain.Cart;
import com.apoorva.demo.domain.CartItem;
import com.apoorva.demo.domain.User;
import com.apoorva.demo.repository.CartItemRepository;
import com.apoorva.demo.repository.CartRepository;
import com.apoorva.demo.service.UserService;
import com.apoorva.demo.service.UserServiceImpl;

@Controller
@SessionAttributes("user")
public class UserController {

	
	@Autowired 
	UserService userService;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	

	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@RequestMapping(value="/login")
	public String login(@RequestParam(required=false) String logout, @RequestParam(required=false) String error, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model, Principal principal) {
		
		String message = "";
		if(error!=null) {
			message="Invalid Credentials";
		}
		if(logout!=null) {
			
			List<CartItem> sessionCartItems = (List<CartItem>)
					httpServletRequest.getSession().getAttribute("CARTITEMS_SESSION");
			
			
			/*find user and cartId from session*/
			User user = userServiceImpl.findByUserName(principal.getName());
			Cart cart = cartRepository.findByUserEquals(user);
			if( cart == null) {
				cart = new Cart();
				cart.setUser(user);
			}
			
			/*updating value directly at the backend*/
			//cart.setCartItems(sessionCartItems);
			cart.getCartItems().clear();
			for(CartItem cartitem: sessionCartItems) {
				cartitem.setCart(cart);
				cart.getCartItems().add(cartitem);
			}
			cartRepository.save(cart);
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth!=null) {
				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			
			message="Logout";
			return "login";
		}		
		
		model.addAttribute("Message", message);
		return "login";
		
	}
	
	
	@RequestMapping(value="/logout")
	public String logout(@RequestParam(required=false) String logout, @RequestParam(required=false) String error, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		
		String message = "";
		if(logout!=null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			if(auth!=null) {
//				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
//			}
			message="Logout";
			return "logout";
		}
		
		model.addAttribute("Message", message);
		return "logout";
		
	}

	@RequestMapping(value="/accessDeniedPage")
	public String accessDenied(Principal principal, Model model) {
		String message = principal.getName()+", Unauthorised access";
		model.addAttribute("Message", message);
		return "accessDenied";
		
	}
	
	@RequestMapping(value= {"/home","/"})
	public String home() {
		
		return "home";
		
	}

}
