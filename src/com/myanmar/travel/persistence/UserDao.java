package com.myanmar.travel.persistence;

import java.util.List;

import com.myanmar.travel.vo.User;

public interface UserDao {
	int getNumOfUsers(String email);
	void create(User user);
	User getUser(String email);
	List<User> getAllUser();
	void delete(int id);
}
