package com.apoorva.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.apoorva.demo.domain.Cart;
import com.apoorva.demo.domain.CartItem;
import com.apoorva.demo.domain.Product;
import com.apoorva.demo.domain.User;
import com.apoorva.demo.dto.CartItemDto;
import com.apoorva.demo.dto.ProductDto;
import com.apoorva.demo.repository.CartRepository;
import com.apoorva.demo.service.CartServiceImpl;
import com.apoorva.demo.service.ProductServiceImpl;
import com.apoorva.demo.service.UserServiceImpl;
import com.apoorva.demo.validator.ProductValidator;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javassist.expr.NewArray;


@Controller
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Autowired 
	ProductValidator productValidator;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	CartRepository cartRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(productValidator);		
	}
	
	// list products
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "/customerview";

    }

    // list products
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showAllProducts(Model model) {
        model.addAttribute("products", productServiceImpl.findAllProducts());
        return "listproducts";

    }
    
	 // show add product
    @RequestMapping(value = "/showaddproductform", method = RequestMethod.GET)
    public String showAddProduct(@ModelAttribute("addproductform")Product product, Model model) {
       
       /*Product product1 = new Product();
       model.addAttribute("product", product1);*/
       return "/addproductform";

    }
   
    //display product details
    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public String showProduct(@PathVariable("productId") Integer productId, Model model) {
    	
    	Optional<Product> product = productServiceImpl.findProductById(productId);
    	if (!product.isPresent()) {
    		
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Product not found");
        }
        model.addAttribute("product", product.get());
        return "showproduct";

    }
    
    //add product form
    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Validated @ModelAttribute("addproductform") Product product, 
    		BindingResult bindingResult, Model model,  final RedirectAttributes redirectAttributes) {
    	
	   		if(bindingResult.hasErrors()) {
	            return "addproductform";
	   		}else {
		   		productServiceImpl.saveProduct(product);   		
	            
		   		// POST/REDIRECT/GET
	            return "redirect:products/" + product.getId();
	   		}
    }
   
   //update product
   @RequestMapping(value = "/updateproduct/{productId}", method = RequestMethod.GET)
   public String updateProduct(@PathVariable("productId") Integer productId, Model model) {
   	
   	Optional<Product> product = productServiceImpl.findProductById(productId);
   	if (!product.isPresent()) {
           model.addAttribute("css", "danger");
           model.addAttribute("msg", "Product not found");
       }
       model.addAttribute("addproductform", product.get());
       return "addproductform";
   }
   
   //delete product
   @RequestMapping(value = "/deleteproduct", method = RequestMethod.POST)
    public String deleteProduct(@ModelAttribute("deleteproductform") Product product,Model model) {
        
            productServiceImpl.deleteProductById(product.getId());;
            
            // POST/REDIRECT/GET
            return "redirect:products";
    }
   
   // show delete product form
   @RequestMapping(value = "/showdeleteproductform/{productId}", method = RequestMethod.GET)
   public String showDeleteProduct(@PathVariable("productId") Integer productId, Model model) {
      
	   Optional<Product> product = productServiceImpl.findProductById(productId);
	   model.addAttribute("product", product.get());
       return "/deleteproductform";

   }
   
   //upload bulk products
   @RequestMapping(value = "/csvfileuploadform", method = RequestMethod.GET)
   public String csvFileUpload(Model model) {
	   	return "/uploadcsvfile";
   }
   
   
   /*
    * 
    * customer views 
    * 
    */
   @RequestMapping(value = "/customerview", method = RequestMethod.GET)
   public String showCustomerView(Model model, Principal principal, HttpServletRequest httpServletRequest ) {
      
	   model.addAttribute("products", productServiceImpl.findAllProducts());
	   
		/*find user and cartId from session
		User user = userServiceImpl.findByUserName(principal.getName());
		Cart cart = cartRepository.findByUserEquals(user);
		if( cart != null && cart.getCartItems() != null) {
			System.out.println("Setting from login");
			httpServletRequest.getSession().setAttribute("CARTITEMS_SESSION", cart.getCartItems());
		}else {
			httpServletRequest.getSession().setAttribute("CARTITEMS_SESSION", new ArrayList<>());
			
		}*/

       
       return "customerview";

   }
   
   
   //list products for customer views
   @RequestMapping(value = "/customerviewproducts", method = RequestMethod.GET)
   public String customershowAllProducts(Model model) {
	   List<ProductDto> allProducts = productServiceImpl.findAllProducts();
       model.addAttribute("products", allProducts);
       
       List<CartItemDto> productDummyCartItems = new ArrayList<>();
       for (ProductDto dto: allProducts) {
    	   productDummyCartItems.add(new CartItemDto());
       }
       model.addAttribute("cartItems", productDummyCartItems);
//       CartItemDto cartItemDto = new CartItemDto();
//       model.addAttribute("cartitem", cartItemDto);
       return "customerlistproducts";
   }
   
   //update product
   @RequestMapping(value = "/searchproduct", method = RequestMethod.GET)
   public String searchByProductOrCategory(@RequestParam("q") String keyword, Model model) {
	   	List<ProductDto> products = productServiceImpl.searchByProductNameOrCategory(keyword);
	   	
	   	model.addAttribute("products", products);
	    return "customerlistproducts";
   }
   

 
}
