package com.myanmar.travel.service;

import com.myanmar.travel.persistence.ContactDao;
import com.myanmar.travel.persistence.ContactDbDao;
import com.myanmar.travel.vo.Contact;

public class ContactDaoService implements ContactService {
	private ContactDao contactDao;
	
	public ContactDaoService() {
		this.contactDao = new ContactDbDao();
	}
	
	@Override
	public void create(Contact contact) {
		contactDao.create(contact);
	}

}
