package com.simplilearn;

public class Product {
	private int ID;
	private String name;
	private float price;
	
	public Product() {	
	}
	
	public Product( String name, float price) {
		this.ID = ID;
		this.name = name;
		this.price = price;	
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
