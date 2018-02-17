package com.moxman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moxman.Dao.UserDao;
import com.moxman.DaoImpl.UserDaoImpl;
import com.moxman.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao userdao;
	
	@RequestMapping(value="adduser",method=RequestMethod.POST)
	public String adduser(@ModelAttribute("user") User user,Model m) {
		
		System.out.println(user);
		userdao.adduserUser(user);
		return "user";
	}
	
/**	@RequestMapping(value="AddRegister",method=RequestMethod.POST)
	public String addRegister(@ModelAttribute("register")Register register,Model m)
	{
		System.out.println(register);
		registerDao.addRegister(register);
		
		List<Register> listRegister=registerDao.retrieveRegister();
		m.addAttribute("registerList",listRegister);
		
		return "redirect:/login";
	} */
	
	@RequestMapping(value="/user")
	public String register() {
		
		return "user";
	} 
}
