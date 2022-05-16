package com.inexture.ems.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.inexture.ems.model.Address;
import com.inexture.ems.model.User;

public interface UserService {
	
	User loginUser(String email,String pass);

	String saveUser(HttpServletRequest request,User user);

	String checkEmail(String email);

	List<User> getAllUser();

	void deleteUser(int id);

	User getUser(int theId);

	void updateUser(HttpServletRequest request, User user, List<Integer> list);
	
	List<Integer> getAddresslist(List<Address> addlist);

	void deleteAddress(List<Integer> list);
}
