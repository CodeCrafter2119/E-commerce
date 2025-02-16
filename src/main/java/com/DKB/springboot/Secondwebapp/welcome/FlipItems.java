package com.DKB.springboot.Secondwebapp.welcome;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FlipItems {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String itemName;
	private String description;
	private int price;
	private boolean done;
	private String imageUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	   public FlipItems(int id, String username, String itemName, String description, int price, boolean done, String imageUrl) {
	        this.id = id;
	        this.username = username;
	        this.itemName = itemName;
	        this.description = description;
	        this.price = price;
	        this.done = done;
	        this.imageUrl = imageUrl;  // Assign value
	    }

	public FlipItems() {

	}

	@Override
	public String toString() {
	    return "FlipItems{" +
	           "id=" + id +
	           ", username='" + username + '\'' +
	           ", itemName='" + itemName + '\'' +
	           ", description='" + description + '\'' +
	           ", price=" + price +
	           ", done=" + done +
	           ", imageUrl='" + imageUrl + '\'' +  
	           '}';
	}

}
