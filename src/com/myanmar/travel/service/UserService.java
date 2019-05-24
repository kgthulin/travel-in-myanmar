package com.myanmar.travel.service;

import java.util.List;

import com.myanmar.travel.vo.User;

public interface UserService {
	int getNumOfUsers(String email);
	void create(User user);
	User getUser(String email);
	List<User> getAllUser();
	void delete(int id);
}
