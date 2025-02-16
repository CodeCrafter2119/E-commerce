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


@Controller
@SessionAttributes("name")
public class FlipControllerjpa {

	@Autowired
	private FlipRepository flipRepository;

	@Autowired
    private FlipServices flipServices;
	// this is welcome page
	@RequestMapping("welcome")
	public String welcomePage(ModelMap model) {

		return "welcome";
	}

	// for list all items
	// Shop Page (Fetch items from the database)
	@RequestMapping("shop")
	public String shopPage(ModelMap model) {
		String username = LoggedInUsername();
		List<FlipItems> items = flipServices.findByUsername(username);
		model.put("items", items);
		return "shop";

	}

	// View cart
	@RequestMapping("cart")
	public String cartPage(ModelMap model) {
		String username = LoggedInUsername();
		List<FlipItems> cartItems = flipRepository.findByUsername(username);
		model.put("cartItems", cartItems);
		return "cart";
	}

	// Add item to cart
	@RequestMapping(value = "add-cart", method = RequestMethod.GET)
	public String addcartPage(ModelMap model, @RequestParam int id, @RequestParam String itemName, 
	                          @RequestParam String description, @RequestParam int price, 
	                          @RequestParam boolean done, @RequestParam String imageUrl) {
	    String username = LoggedInUsername();
	    FlipItems cartItems = new FlipItems(id, username, itemName, description, price, done, imageUrl);
	    flipRepository.save(cartItems);
	    return "redirect:shop";
	}
	
	  // Place Order
    @RequestMapping(value = "place-order", method = RequestMethod.POST)
    public String placeOrder() {
        String username = LoggedInUsername();
        List<FlipItems> cartItems = flipRepository.findByUsername(username);

        // Update the 'done' status for all items in the cart
        for (FlipItems item : cartItems) {
            item.setDone(true); // Set 'done' to true
            flipRepository.save(item); // Save the updated item
        }

        return "redirect:cart"; // Redirect back to the cart page
    }
	
	//delete
	@RequestMapping("delete-cart")
	public String deleteItem(@RequestParam int id) {
		flipRepository.deleteById(id);
		return "redirect:cart";
	}

	private String LoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}


}
