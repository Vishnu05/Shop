package com.moxman.controllers;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moxman.Dao.UserDao;
import com.moxman.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDAO;
	
	@RequestMapping(value="adduser",method=RequestMethod.POST)
	public String adduser(@ModelAttribute("user") User user,Model m) {
		
		System.out.println("user Controller instaniated----"+user);
		userDAO.adduserUser(user);
		return "redirect:user";
	}
	
	@RequestMapping("user")
	public String showuser(Model m)
	{
		User user=new User();
		m.addAttribute(user);
		return "user";
	}
	
 @RequestMapping(value="/login")
 public String login() {
	 return "login";
 }
	 
}
