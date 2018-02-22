package com.moxman.controllers;

 import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.moxman.Dao.UserDao;
import com.moxman.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao userDAO;
	
	
	@RequestMapping(value="adduser",method=RequestMethod.POST)
	public String adduser(@ModelAttribute("user") User user,Model m) {
		
		System.out.println("user Controller instaniated----"+user);
		userDAO.createuser(user);
		return "redirect:user";
	}
	
	@RequestMapping("user")
	public String showuser(Model m)
	{
	 
		User user=new User();
		m.addAttribute(user);
		return "user";
	}
	
	@RequestMapping("/login_success")
	public ModelAndView loginSuccess(HttpSession session, Model m) {
		
		System.out.println("entering the login security");
		
		String page = null;
		
		boolean loggedIn = true;
		// Retrieving the userId;
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("email", email);
		session.setAttribute("loggedIn", loggedIn);
		
		// Retrieving the role
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role="Role_User";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
		    	 session.setAttribute("email", email);
		    	 m.addAttribute("role",authority.getAuthority());
		    	 session.setAttribute("role", authority.getAuthority());
		    	 System.out.println(authority.getAuthority());
		    	 page="admin";		    	 
		    	 break;
		     }
		     else 
		     {
		    	 session.setAttribute("LoggedIn", "true");
		    	 session.setAttribute("Administrator", "true");
		    	 m.addAttribute("role",authority.getAuthority());
		    	 session.setAttribute("role", authority.getAuthority());
		    	 page="admin";
		    	 break;
		    }
		} 
		
		return new ModelAndView(page,"email",email);
		
	}
	
 @RequestMapping(value="/login")
 public String login() {
	 return "login";
 }
 
 	@RequestMapping(value="/loginf")
 	public String loginf() {
 		
 		return "loginf";
 	}

}
