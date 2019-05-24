package com.myanmar.travel.vo;

import java.io.Serializable;

public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer restaurant_id;
	private String name;
	private int price;
	private String phone;
	private Location location;

	public Restaurant() {
		super();
	}

	public Restaurant(Integer restaurant_id, String name, int price, String phone, Location location) {
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.price = price;
		this.phone = phone;
		this.location = location;
	}

	public Integer getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(Integer restaurant_id) {
		this.restaurant_id = restaurant_id;
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
