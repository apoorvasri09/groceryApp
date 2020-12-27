package com.apoorva.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apoorva.demo.domain.Cart;
import com.apoorva.demo.domain.CartItem;
import com.apoorva.demo.domain.Product;
import com.apoorva.demo.domain.User;
import com.apoorva.demo.dto.CartItemDto;
import com.apoorva.demo.repository.CartItemRepository;
import com.apoorva.demo.repository.CartRepository;
import com.apoorva.demo.repository.CategoryRepository;
import com.apoorva.demo.repository.UserRepository;
import com.apoorva.demo.service.CartServiceImpl;
import com.apoorva.demo.service.ProductServiceImpl;
import com.apoorva.demo.service.UserServiceImpl;

@Controller
public class CartController {
	
		@Autowired
		UserServiceImpl userServiceImpl;

		@Autowired
		CartServiceImpl cartServiceImpl;
		
		@Autowired
		ProductServiceImpl productServiceImpl;
		
		@Autowired
		CartRepository cartRepository;
		
		@Autowired
		CartItemRepository cartItemRepository;
		
	   
	   
//	   @RequestMapping(value = "/savecartitem", method = RequestMethod.POST)
//	   public String servecartitemform(@ModelAttribute("additemtocartform") CartItemDto cartItemDto,
//			   
//			   Principal principal,
//			   Model model) {
//		   
//		   CartItem cartItem = new CartItem();
//		   cartItem.setPrice(cartItemDto.getPrice());
//		   cartItem.setQuantity(cartItemDto.getQuantity());
//		   cartItem.setProduct(productServiceImpl.findProductById(cartItemDto.getProductId()).get());
//		   
//		   User user = userServiceImpl.findByUserName(principal.getName());
//		   cartItem.setCart(cartRepository.findByUserEquals(user));
//		   
//		   if(cartItem.getCart() == null) {
//			   Cart cart = new Cart();
//			   cart.setUser(user);
//			   cartServiceImpl.saveCart(cart);
//			   cartItem.setCart(cart);
//		   }
//		   
//		   cartItemRepository.save(cartItem);
//		   
//		   return "redirect:customerviewproducts";
//	   }
	   
	   //save or update cart item
		@RequestMapping(value = "/savecartitem", method = RequestMethod.POST)
		public String servecartitemform( @ModelAttribute("cartItems") CartItemDto cartItemDto,
		   @RequestParam int productId, @RequestParam int quantity, HttpServletRequest request,
		    Principal principal, Model model){
			
				CartItem cartItem = new CartItem();
				cartItem.setQuantity(quantity);
				Product product = productServiceImpl.findProductById(productId).orElse(null);
				cartItem.setProduct(product);
		
				model.addAttribute("cartItems", cartItemDto);
				
				@SuppressWarnings("unchecked")
				List<CartItem> sessionCartItems = (List<CartItem>)
				request.getSession().getAttribute("CARTITEMS_SESSION");
		   
				if(sessionCartItems == null) {
					sessionCartItems = new ArrayList<CartItem>();
					sessionCartItems.add(cartItem);
					}
				else{
					sessionCartItems.add(cartItem);
				}
			request.getSession().setAttribute("CARTITEMS_SESSION", sessionCartItems);
			return "redirect:customerviewproducts";
		}
		
		
	   /*
	    * show customer cart
	    */
	   @RequestMapping(value = "/usercart", method = RequestMethod.GET)
	   public String customerCart(Model model, HttpServletRequest request, Principal principal) {
		   
		   List<CartItem> sessionCartItems = (List<CartItem>)
	               request.getSession().getAttribute("CARTITEMS_SESSION");
		   
		   System.out.println("inside /usercart");
		   
		   if(sessionCartItems == null){
			   
			   User user = userServiceImpl.findByUserName(principal.getName());
			   System.out.println("1");
			   Cart cart = cartRepository.findByUserEquals(user);
			   System.out.println("2");
			   List<CartItem> cartItems = cart.getCartItems();
			   sessionCartItems = cartItems;
			   System.out.println("3");
			   request.getSession().setAttribute("CARTITEMS_SESSION", sessionCartItems);
			   System.out.println("4");
		   }
		   
		   System.out.println("5");
		   model.addAttribute("usercart", sessionCartItems);
		   
		   System.out.println("6");
	       return "usercart";
	   }
	   
	   //remove session attribute
	   @RequestMapping(value = "/updatequantity", method = RequestMethod.POST)
	   public String updateSessionCartItem(@RequestParam Integer productId, @RequestParam Integer quantity,
			   Model model, HttpServletRequest request) {

		   @SuppressWarnings("unchecked")
		List<CartItem> sessionCartItems = (List<CartItem>)
	               request.getSession().getAttribute("CARTITEMS_SESSION");
		   
		   for(CartItem cartitem: sessionCartItems) {
			   
			   Integer cartProductIdInteger = cartitem.getProduct().getId();
			   if(cartProductIdInteger.equals(productId)) { 
				   cartitem.setQuantity(quantity);
			   }
		   }
		   
		   request.getSession().setAttribute("CARTITEMS_SESSION", sessionCartItems);
		   model.addAttribute("usercart", sessionCartItems);
		   
	       return "usercart";
	   }
	   
	 //delete session attribute
	   @RequestMapping(value = "/deletecartitem", method = RequestMethod.POST)
	   public String deleteSessionCartItem(@RequestParam Integer productId,
			   Model model, HttpServletRequest request) {

		   
		   @SuppressWarnings("unchecked")
		List<CartItem> sessionCartItems = (List<CartItem>)
	               request.getSession().getAttribute("CARTITEMS_SESSION");
		   
		   int indexToBeRomoved = 0;
		   for(CartItem cartitem: sessionCartItems) {
			   
			   Integer cartProductIdInteger = cartitem.getProduct().getId();
			   if(cartProductIdInteger.equals(productId)) { 
				   indexToBeRomoved = sessionCartItems.indexOf(cartitem);
			   }
		   }
		   sessionCartItems.remove(indexToBeRomoved);
		   request.getSession().setAttribute("CARTITEMS_SESSION", sessionCartItems);
		   model.addAttribute("usercart", sessionCartItems);
	       return "usercart";
	   }

}
