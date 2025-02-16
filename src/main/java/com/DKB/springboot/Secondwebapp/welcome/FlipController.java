package com.DKB.springboot.Secondwebapp.welcome;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;





//@Controller
//@SessionAttributes("name")
public class FlipController {
	
	@Autowired
	private FlipServices flipservices;
     //this is welcome page
	@RequestMapping("welcome")
	public String welcomePage(ModelMap model) {
	
		return "welcome";
	}
	//for list all items
	@RequestMapping("shop")
	public String shopPage(ModelMap model) {
		String username=LoggedInUsername();
		
		List<FlipItems> items = flipservices.findByUsername(username);
		model.addAttribute("item", items);
		return "shop";
	}
	
	 // Cart Page (Lists Cart Items)
    @RequestMapping("cart")
    public String cartPage(ModelMap model) {
        List<FlipItems> cartItems = flipservices.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }
    
    // Add Item to Cart
    @RequestMapping(value = "add-cart", method = RequestMethod.GET)
    public String addItemToCart(@RequestParam int id) {
        flipservices.addToCart(id);
        return "redirect:cart";
    }
    
    @RequestMapping("delete-cart")
    public String deleteItem(@RequestParam int id) {
    	flipservices.deleteItem(id);
    	return "redirect:cart";
    }
    
    private String LoggedInUsername() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	return authentication.getName();
    }
	
	//showing order page if clicks addCart and shows user details in the form
//	@RequestMapping(value = "add-cart", method = RequestMethod.GET)
//	public String AddItemToCart(ModelMap model,@RequestParam int id) {
//		FlipItems items1 = flipservices.addfindbyId(id);
//		model.addAttribute("items1", items1);
//
//		return "cart";
//	}
	
	//for posting userDetails 
//	@RequestMapping(value = "add-cart", method = RequestMethod.POST)
//	public String AddItemToCart(ModelMap model, FlipItems items, BindingResult result) {
//		if (result.hasErrors()) {
//			return "shop";
//		}
//		flipservices.addItem(items.getId(), items.getUsername(), items.getItemName(), items.getDescription(), items.getPrice(),items.getDone(),items.getImageUrl());
//		return "redirect:cart";
//	}
}
