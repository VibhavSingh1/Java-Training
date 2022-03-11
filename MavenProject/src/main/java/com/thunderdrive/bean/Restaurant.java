package com.thunderdrive.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Restaurant {
		
	String name;
	String phone;
	String operatingHours;
	float ratings;
	
	Address address; // HAS-A Relationship | 1 to 1
	
	List<String> searchKeywords; // HAS-A Relationship | 1 to Many
	
	List<FoodItem> menu; // HAS-A Relationship | 1 to Many 
	

	public Restaurant() {
		System.out.println("[Restaurant] - Object Constructed with Default Constructor");
	}
	
	//@Autowired annotation makes the Spring FW IOC container to understand automatically to use Constructor for injecting the address in Restaurant.
	//@Autowired //Constructor Injection Autowired
	Restaurant(Address address) {
		System.out.println("[Restaurant] - Object Constructed with Address as input to Constructor");
		System.out.println("[Restaurant] - Constructor Injection");
		
		this.address = address;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public Address getAddress() {
		return address;
	}
	
	// setAddress method takes reference as input rather than value
	// Input to the method is Address which is a reference type
	@Autowired //Setter Injection Autowired
	public void setAddress(Address address) {
		
		System.out.println("[Restaurant] - Setter Injection");
		this.address = address;
	}
	
	//
	public List<String> getSearchKeywords() {
		return searchKeywords;
	}

	
	public void setSearchKeywords(List<String> searchKeywords) {
		this.searchKeywords = searchKeywords;
	}
	
	// 
	public List<FoodItem> getMenu() {
		return menu;
	}

	public void setMenu(List<FoodItem> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", phone=" + phone + ", operatingHours=" + operatingHours + ", ratings="
				+ ratings + ", address=" + address + "]";
	}
	
	 

}
