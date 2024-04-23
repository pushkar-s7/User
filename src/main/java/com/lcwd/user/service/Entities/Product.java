package com.lcwd.user.service.Entities;

public class Product {
	
	
	private Long id;
	private String name;
	private String brand;
	private double price;
	private int availability;
	private String category;

	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String name, String brand, double price, int availability, String category) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availability = availability;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
