package com.inexture.ems.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inexture.ems.dao.UserDAO;
import com.inexture.ems.model.Address;
import com.inexture.ems.model.User;

@Service
public class UserServiceIMP implements UserService {
	
	private static Logger log = LogManager.getLogger(UserServiceIMP.class);
	
	@Autowired
	private UserDAO userDAO;

//---------------------------------------------------
	@Transactional
	public User loginUser(String email,String pass) {
		User u = userDAO.getUserbyEmail(email);
		
		if(u != null && pass.equals(u.getPassword())) {
			return u;
		}
		else
			return null;
	}
//------------------------------------------------
	@Override
	@Transactional
	public String saveUser(HttpServletRequest request,User user) {
		user.setImage(user.getImage1().getBytes());
		user.setRole("User");
		
		String[] address = request.getParameterValues("address[]");
		String[] zip = request.getParameterValues("zip[]");
		String[] city = request.getParameterValues("city[]");
		String[] state = request.getParameterValues("state[]");
		String[] contry = request.getParameterValues("contry[]");
		
		ArrayList<Address> list = new ArrayList<Address>();
		//create address object
		for(int i=0;i<zip.length;i++) {
			if(!(address[i].equals("") || city[i].equals("") || contry[i].equals("") 
					|| zip[i].equals(""))) {
				Address obj = new Address();
				obj.setAddress(address[i]);
				obj.setCity(city[i]);
				obj.setContry(contry[i]);
				obj.setState(state[i]);
				obj.setZip(Integer.parseInt(zip[i]));
				obj.setUser(user);
				list.add(obj);
			}	
		}
		user.setList(list);
		
		int a = userDAO.saveUser(user);
		
		if(a != 0) {
			return "success";
		}
		else {
			return "error";
		}
	}

//-----------------------------------------------
	@Override
	@Transactional
	public String checkEmail(String email) {
		User u = userDAO.getUserbyEmail(email);
		
		if(u != null) {
			log.debug(u.getId());
			return "Duplicate";
		}
		else
			return "Not Duplicate";
	}
//-----------------------------------------------------	
	@Override
	@Transactional
	public List<User> getAllUser() {
		List<User> list = userDAO.getAllUser();
		return list;
	}
//-----------------------------------------------------	
	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
		
	}
//--------------------------------------------------------	
	@Override
	@Transactional
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}
//---------------------------------------------------------	
	@Override
	@Transactional
	public void updateUser(HttpServletRequest request, User user,List<Integer> list1) {
		if(!(user.getImage1().isEmpty())) {
			user.setImage(user.getImage1().getBytes());
		}
		user.setRole("User");
		
		String[] addressid = request.getParameterValues("addressid");
		String[] address = request.getParameterValues("address[]");
		String[] zip = request.getParameterValues("zip[]");
		String[] city = request.getParameterValues("city[]");
		String[] state = request.getParameterValues("state[]");
		String[] contry = request.getParameterValues("contry[]");
		
		ArrayList<Address> list = new ArrayList<Address>();
		List<Integer> add = new ArrayList<Integer>();
		//create address object
		for(int i=0;i<zip.length;i++) {
			if(!(address[i].equals("") || city[i].equals("") || contry[i].equals("") 
					|| zip[i].equals(""))) {
				Address obj = new Address();
				if(!addressid[i].equals("")) {
					int ID =Integer.parseInt(addressid[i]);
					add.add(ID);
					obj.setAddressid(ID);
				}
				obj.setAddress(address[i]);
				obj.setCity(city[i]);
				obj.setContry(contry[i]);
				obj.setState(state[i]);
				obj.setZip(Integer.parseInt(zip[i]));
				obj.setUser(user);
				list.add(obj);
			}	
		}
		user.setList(list);
		userDAO.updateUser(user);
		
		list1.removeAll(add);
		deleteAddress(list1);
	}
//-----------------------------------------------------	
	@Override
	@Transactional
	public void deleteAddress(List<Integer> list) {
		for(int id : list) {
			userDAO.deleteAddress(id);
		}
	}
//-------------------------------------------------------	
	@Override
	public List<Integer> getAddresslist(List<Address> addlist) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(Address a : addlist) {
			list.add(a.getAddressid());
		}
		
		return list;
	}
}
