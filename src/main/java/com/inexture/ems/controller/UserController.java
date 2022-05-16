package com.inexture.ems.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inexture.ems.model.User;
import com.inexture.ems.service.UserService;

@Controller
@MultipartConfig(maxFileSize = 16177215)
public class UserController {
	
	private static Logger log = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
//--------------------------------------------------	
	@GetMapping("/registration-page")
	public String getRegistrationPage(Model model) {
		model.addAttribute("title", "New User Registration Form");
		model.addAttribute("header", "Registration Form");
		model.addAttribute("action", "register");
		model.addAttribute("buttun", "Register");
		
		return "Registration";
	}	
//-----------------------------------------------------	
	@RequestMapping(path = "/register", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String registerUser(HttpServletRequest request,@ModelAttribute("form") User user,
			Model model) 
	{	
		String msg = service.saveUser(request,user);
		model.addAttribute("msg", msg);
		log.debug(msg);
		return "index";
	}
//-------------------------------------------------------
	@PostMapping("/checkemail.ajax")
	public @ResponseBody String checkEmail(@RequestParam("email") String email) {
		
		log.debug(email);
		String msg = service.checkEmail(email);
		
		log.debug(msg);
		return msg;
	}
//---------------------------------------------------------
	@GetMapping("/User-Dashboard")
	public String getUserPage(Model model) {
		model.addAttribute("website_name", "User Pannel");
		model.addAttribute("home_page", "User-Dashboard");
		return "User-Dashboard";
	}
	
}
