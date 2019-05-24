package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.persistence.UserDao;
import com.myanmar.travel.persistence.UserDbDao;
import com.myanmar.travel.vo.User;

public class UserDaoService implements UserService {
	private UserDao userDao;
	
	public UserDaoService() {
		this.userDao = new UserDbDao();
	}

	@Override
	public int getNumOfUsers(String email) {
		return userDao.getNumOfUsers(email);
	}
	
	@Override
	public void create(User user) {
		userDao.create(user);
	}

	@Override
	public User getUser(String email) {
		return userDao.getUser(email);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}
}
