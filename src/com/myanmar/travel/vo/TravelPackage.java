package com.myanmar.travel.vo;

import java.io.Serializable;

public class TravelPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Location location;
	private Hotel hotel;
	private Restaurant restaurant;
	private Ticket ticket;
	private int price;
	private int number_of_day;
	private int quantity;
	
	public TravelPackage() {
		super();
	}

	public TravelPackage(Integer id, Location location, Hotel hotel, Restaurant restaurant, Ticket ticket, int price, int number_of_day, int quantity) {
		super();
		this.id = id;
		this.location = location;
		this.hotel = hotel;
		this.restaurant = restaurant;
		this.ticket = ticket;
		this.price = price;
		this.number_of_day = number_of_day;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber_of_day() {
		return number_of_day;
	}

	public void setNumber_of_day(int number_of_day) {
		this.number_of_day = number_of_day;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
