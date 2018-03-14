package com.moxman.controllers;
import java.util.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.moxman.Dao.*;
import com.moxman.DaoImpl.*;
import com.moxman.model.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class IndexController {
	
	@Autowired
	SubcategoryDAOImpl subcategoryDAOImpl;
	
	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	
	
	 
/*	@RequestMapping("/")
	   public String index(Model m) {
		
		List<Category> catlist = categoryDAOImpl.getAllCategory();
		List<Subcategory> subcatlist = subcategoryDAOImpl.getAllSubcategory();
		m.addAttribute("catlist", catlist);
		m.addAttribute("subcatlist",subcatlist);
		
		
	         return "index";
	   } */
	
	@RequestMapping(value="/admin")
	   public String gotoadmin() {
	         return "admin";
	   }
	
	@RequestMapping(value="/Billing_Recipet")
	public String invoice() {
		
		return "invoice";
	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessdeniedhandler() {
		
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errortitle","Good Try");
		mv.addObject("errordescription","" );
		mv.addObject("title","");
		return mv;
	}
	
	@RequestMapping(value="/userprofile")
	public String userprofile() {
		
		return "userprofile";
	}
	     
}
