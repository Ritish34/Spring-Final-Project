package com.inexture.ems.dao;

import java.util.List;

import com.inexture.ems.model.User;

public interface UserDAO {
	
	User getUserbyEmail(String email);

	int saveUser(User user);

	List<User> getAllUser();

	void deleteUser(int id);

	User getUser(int theId);

	void updateUser(User user);

	void deleteAddress(int id);
}
