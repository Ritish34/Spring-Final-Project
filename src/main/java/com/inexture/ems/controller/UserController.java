package com.inexture.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
//	@GetMapping("/registration-page")
	@RequestMapping(value = "/registration-page", method = {RequestMethod.POST, RequestMethod.GET})
	public String getRegistrationPage(Model model) {
		model.addAttribute("title", "New User Registration Form");
		model.addAttribute("header", "Registration Form");
		model.addAttribute("action", "register");
		model.addAttribute("buttun", "Register");
		
		return "Registration";
	}
//-----------------------------------------------------	
	@RequestMapping(path = "/register", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String registerUser(HttpServletRequest request,@Valid @ModelAttribute("form") User user,BindingResult br,
			Model model) 
	{	
		if(br.hasErrors())  
        {  
			List<FieldError> errorList = br.getFieldErrors();
			List<String> errors = new ArrayList<String>();
			
			for( FieldError er : errorList) {
				errors.add(er.getDefaultMessage());
			}
			
			model.addAttribute("error",errors);
            return "forward:/registration-page";  
        }
		else
		{
			String msg = service.saveUser(request,user);
			model.addAttribute("msg", msg);
			log.debug(msg);
			return "index";
		}
	}
//-------------------------------------------------------
	@PostMapping("/checkemail.ajax")
	public @ResponseBody String checkEmail(@RequestParam("email") String email) {
		
		String msg = service.checkEmail(email);
		
		log.debug(msg);
		return msg;
	}
//---------------------------------------------------------
	@GetMapping("/User-Dashboard")
	public String getUserPage(Model model) {
		model.addAttribute("website_name", "Employee Management System");
		model.addAttribute("home_page", "User-Dashboard");
		return "User-Dashboard";
	}
}
