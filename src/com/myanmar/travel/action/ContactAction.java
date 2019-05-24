package com.myanmar.travel.action;

import com.myanmar.travel.service.ContactDaoService;
import com.myanmar.travel.service.ContactService;
import com.myanmar.travel.vo.Contact;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ContactAction extends ActionSupport implements ModelDriven<Contact> {
	private static final long serialVersionUID = 1L;

	private Contact contact = new Contact();
	private ContactService contactService = new ContactDaoService();
	
	@Override
	public Contact getModel() {
		return contact;
	}

	public String contact() {
		contactService.create(contact);
		return SUCCESS;
	}
}
