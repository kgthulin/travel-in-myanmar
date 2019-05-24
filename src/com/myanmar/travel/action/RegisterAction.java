package com.myanmar.travel.action;

import com.myanmar.travel.service.UserDaoService;
import com.myanmar.travel.service.UserService;
import com.myanmar.travel.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;

	private User user = new User();
	private UserService userService = new UserDaoService();
	
	@Override
	public User getModel() {
		return user;
	}

	public String register() {
		int numOfUsers = userService.getNumOfUsers(user.getEmail());
		if (numOfUsers > 0) {
			return "input";
		}
		if (user.getPassword().equals(user.getCpassword())) {
			userService.create(user);
			return SUCCESS;
		}
		return "input";
	}
	
	@Override
	public void validate() {
		int numOfUsers = userService.getNumOfUsers(user.getEmail());
		if(numOfUsers > 0) {
			addActionError("Email has already been existed!");
		}
		if(!user.getPassword().equals(user.getCpassword())) {
			addActionError("Password & confirm password must be equal!");
		}
	}
}
