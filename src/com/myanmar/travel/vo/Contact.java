package com.myanmar.travel.vo;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String message;
	
	public Contact() {
		super();
	}

	public Contact(String name, String phone, String email, String message) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
