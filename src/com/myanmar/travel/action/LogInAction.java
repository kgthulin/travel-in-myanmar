package com.myanmar.travel.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myanmar.travel.service.UserDaoService;
import com.myanmar.travel.service.UserService;
import com.myanmar.travel.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LogInAction extends ActionSupport implements ModelDriven<User>, SessionAware {
	private static final long serialVersionUID = 1L;

	private User user = new User();
	private UserService userService = new UserDaoService();
	private SessionMap<String, Object> sessionMap;	
	
	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		this.sessionMap = (SessionMap<String, Object>) map;
	}
	
	public String login() {
		int numOfUsers = userService.getNumOfUsers(user.getEmail());
		if (numOfUsers > 0) {
			User u = userService.getUser(user.getEmail());
			if (user.getPassword().equals("admin123") && user.getEmail().equals("admin@gmail.com")) {
				sessionMap.put("adminSession", u);
				return "successAdmin";
			}
			if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
				sessionMap.put("userSession", u);
				return "successUser";
			}
		}
		return "input";
	}

	@Override
	public void validate() {
		int numOfUsers = userService.getNumOfUsers(user.getEmail());
		if(numOfUsers <= 0) {
			addActionError("Invalid Credentials!");
		} else {
			User u = userService.getUser(user.getEmail());
			if(!user.getPassword().equals(u.getPassword()))
				addActionError("Invalid Credentials!");
		}
	}
}
