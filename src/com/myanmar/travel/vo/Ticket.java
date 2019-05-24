package com.myanmar.travel.vo;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer ticket_id;
	private String line_name;
	private int price;
	private Location location;
	
	public Ticket() {
		super();
	}

	public Ticket(Integer ticket_id, String line_name, int price, Location location) {
		super();
		this.ticket_id = ticket_id;
		this.line_name = line_name;
		this.price = price;
		this.location = location;
	}

	public Integer getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getLine_name() {
		return line_name;
	}

	public void setLine_name(String line_name) {
		this.line_name = line_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
