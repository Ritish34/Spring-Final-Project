package com.inexture.ems.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inexture.ems.model.User;
import com.inexture.ems.service.UserService;

@Controller
public class LoginController {
	
	private static Logger log = LogManager.getLogger(LoginController.class);
	
	@Autowired
	private UserService service;
	
	@GetMapping("/home")
    public String gethomePage(Model model) {
        return "index";
    }
	
	@PostMapping("/home")
    public String posthomePage(Model model) {
        return "index";
    }
		
	@PostMapping("/login")
	public String getLogin(@RequestParam("email") String email,@RequestParam("password") String pass,
			HttpSession session,Model model) {
		
		log.debug("Login Mapping Called");
		
		User u = service.loginUser(email, pass);
		model.addAttribute("object", u);
		
		if(u != null && u.getRole().equals("admin")) {
			session.setAttribute("username", u.getFirst_name());
			session.setAttribute("id", u.getId());
			session.setAttribute("role", u.getRole());
			
			log.debug("Admin Login Sucessfull");
			return "redirect:/Admin-Dashboard";
		}
		else if(u != null && u.getRole().equals("User")){
			session.setAttribute("username", u.getFirst_name());
			session.setAttribute("id", u.getId());
			session.setAttribute("role", u.getRole());
			
			log.debug("User Login Sucessfully");
			return "redirect:/User-Dashboard";
		}
		else {
			String msg = "Username/Password is incorrect";
			model.addAttribute("msg", msg);
			model.addAttribute("email", email);
			
			log.debug("Login Fails");
			return "forward:/home";
		}
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session,Model model) {
		
		session.removeAttribute("username");
		session.removeAttribute("id");
		session.invalidate();
		
		log.debug("Logout Called");
		log.debug("Session Invalidate");
		return "redirect:/home";
	}	
}