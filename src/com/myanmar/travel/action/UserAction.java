package com.myanmar.travel.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.myanmar.travel.service.PackageDaoService;
import com.myanmar.travel.service.PackageService;
import com.myanmar.travel.service.UserDaoService;
import com.myanmar.travel.service.UserService;
import com.myanmar.travel.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;

	private User user = new User();
	private UserService userService = new UserDaoService();
	private List<User> userList;
	private PackageService packageService = new PackageDaoService();
	
	@Override
	public User getModel() {
		return user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String viewUser() {
		userList = userService.getAllUser();
		return SUCCESS;
	}

	public String deleteUser() {
		String id = ServletActionContext.getRequest().getParameter("currentId");
		int userId = Integer.parseInt(id);
		userService.delete(userId);
		packageService.deleteByUser(userId);
		return SUCCESS;
	}
}
