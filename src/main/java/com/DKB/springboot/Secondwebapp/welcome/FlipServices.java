package com.DKB.springboot.Secondwebapp.welcome;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class FlipServices {

	private static List<FlipItems> items = new ArrayList<>();
	private static List<FlipItems> cart = new ArrayList<>(); // New cart list
	
	public static int count = 0;
	public static String[] people = {"Dahal", "narzary"};

    // Static block to initialize items for each person
    static {
        // Loop through each person
        for (String person : people) {
            // Add items for each person
            items.add(new FlipItems(count++, person, "Iphone14", "Discount 60%", 45000, false, "images/iphone_14.png"));
            items.add(new FlipItems(count++, person, "Iphone15", "Discount 60%", 55000, false, "images/iphone_15.png"));
            items.add(new FlipItems(count++, person, "Iphone16", "Discount 60%", 75000, false, "images/iphone_16.png"));
        }
    }

	// for list all items with UserName
	public List<FlipItems> findByUsername(String username) {
		Predicate<? super FlipItems> predicate = item -> item.getUsername().equalsIgnoreCase(username);
		return items.stream().filter(predicate).toList();
	}

	
	 public FlipItems findById(int id) {
	        return items.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
	    }
	 
	// Add item to cart
	    public void addToCart(int id) {
	        FlipItems item = findById(id);
	        if (item != null) {
	            cart.add(item);
	        }
	    }
	    //for delete item from cart
	    public void deleteItem(int id) {
			Predicate<? super FlipItems> predicate= item -> item.getId() ==id;
			cart.removeIf(predicate);
		}
	 // Get all cart items
	    public List<FlipItems> getCartItems() {
	        return cart;
	    }


}
