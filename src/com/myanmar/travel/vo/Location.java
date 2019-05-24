package com.myanmar.travel.vo;

import java.io.Serializable;

public class Location implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer location_id;
	private String name;
	private double mile;
	
	public Location() {
		super();
	}

	public Location(Integer location_id, String name, double mile) {
		super();
		this.location_id = location_id;
		this.name = name;
		this.mile = mile;
	}

	public Integer getLocation_id() {
		return location_id;
	}
	
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMile() {
		return mile;
	}
	
	public void setMile(double mile) {
		this.mile = mile;
	}
}
