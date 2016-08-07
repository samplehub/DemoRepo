package com.example.sales;

public class Item {
	
	private String itemName;
     private int quantity;
     private int price;
     
     public Item(String name, int quantity, int price) {
         this.itemName = name;
         this.quantity = quantity;
         this.price = price;
 }
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
