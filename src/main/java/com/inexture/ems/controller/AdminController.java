package com.inexture.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.inexture.ems.model.Address;
import com.inexture.ems.model.User;
import com.inexture.ems.service.UserService;

@Controller
public class AdminController {
	
	private static Logger log = LogManager.getLogger(AdminController.class);
	
	@Autowired
	private UserService service;
	
	@GetMapping("/Admin-Dashboard")
	public String getAdminPage(Model model) {
		model.addAttribute("website_name", "Admin Pannel");
		model.addAttribute("home_page", "Admin-Dashboard");
		model.addAttribute("profile_page", "profile-page");
		return "Admin-Dashboard";
	}
	
	@GetMapping("/profile-page")
	public String getProfile(Model model) {
		model.addAttribute("website_name", "Admin Pannel");
		model.addAttribute("home_page", "Admin-Dashboard");
		model.addAttribute("profile_page", "profile-page");
		return "Profile";
	}
	
	@RequestMapping(value = "/ShowAllUser", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public String getUsers(){
		
		log.debug("Ajax Call For All user is Reach To Controller");
		
		ArrayList<User> list =(ArrayList<User>)service.getAllUser();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject json = new JsonObject();

		json.add("data", gson.toJsonTree(list));
		
		log.debug("List Of All User Is Sent Back Through Ajax");
		return json.toString();
	}
	
	@PostMapping("/DeleteUser")
	@ResponseBody
	public String deleteUserData(@RequestParam("UserId") int id) {
		service.deleteUser(id);
		log.debug("User Id : "+id+"is Deleted");
		return "sucess";
	}
	
	@GetMapping("/adduser")
	public String addNewUser(Model model) {
		model.addAttribute("title", "Add New User");
		model.addAttribute("header", "Add New User Form");
		model.addAttribute("action", "add");
		model.addAttribute("buttun", "Register");

		return "Registration";
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String registerUser(HttpServletRequest request,@ModelAttribute("form") User user,
			Model model) 
	{	
		String msg = service.saveUser(request,user);
		log.debug("User Save Successfully");
		model.addAttribute("msg", msg);
		return "redirect:/Admin-Dashboard";
	}
	
	@PostMapping("/update-{id}")
	public String editProfile(@PathVariable int id) {
		return"redirect:/update-"+id;
	}
	
	@GetMapping("/update-{id}")
	public String updateUserPageOpen(@PathVariable int id,Model model) {
		model.addAttribute("website_name", "Admin Pannel");
		model.addAttribute("home_page", "Admin-Dashboard");
		model.addAttribute("profile_page", "profile-page");
		model.addAttribute("title", "Update User");
		model.addAttribute("header", "Update User Form");
		model.addAttribute("action", "updateUser");
		model.addAttribute("buttun", "Update");
		model.addAttribute("status", "update");
		model.addAttribute("UserId", id);	
		return "Registration";
	}
	@RequestMapping(value = "/GetOneUserData", method = RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public String getUserData(@RequestParam("UserId") int id,HttpSession s) {
		User theUser = service.getUser(id);
		
		theUser.setBase64Image(theUser.getBase64Image());
		
		s.setAttribute("image", theUser.getImage());
		
		ArrayList<User> list = new ArrayList<User>();
		List<Address> list1 = theUser.getList();
		theUser.setList(null);
		list.add(theUser);
		
		s.setAttribute("addlist", service.getAddresslist(list1));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject json = new JsonObject();
		json.add("data", gson.toJsonTree(list));
		json.add("Address", gson.toJsonTree(list1));
		
		log.debug("Json data fro one user (To Display PRofile) is send");
		return json.toString();
	}
	
	@PostMapping("/updateUser")
	public String updateUser(HttpServletRequest request,@ModelAttribute("form") User user,
			Model model,HttpSession s) {
		
		int id = Integer.parseInt(request.getParameter("userid"));
		
		if (user.getImage1().isEmpty()) {
			user.setImage((byte[]) s.getAttribute("image"));
		}
		user.setId(id);
		@SuppressWarnings("unchecked")
		List<Integer> list = (List<Integer>) s.getAttribute("addlist");
		service.updateUser(request,user,list);
		
		return "redirect:/update-"+id;
	}
}