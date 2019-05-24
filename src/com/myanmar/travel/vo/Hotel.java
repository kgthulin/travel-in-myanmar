package com.myanmar.travel.vo;

import java.io.Serializable;

public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer hotel_id;
	private String name;
	private int price;
	private double rating;
	private String phone;
	private Location location;
	
	public Hotel() {
		super();
	}

	public Hotel(Integer hotel_id,String name, int price, double rating, String phone, Location location) {
		super();
		this.hotel_id = hotel_id;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.phone = phone;
		this.location = location;
	}

	public Integer getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
