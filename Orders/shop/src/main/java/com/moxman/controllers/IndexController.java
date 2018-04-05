package com.moxman.controllers;
import java.util.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Aggregator;
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
	
	
	@Autowired
	ProductDAO productdao;
	 
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
	     
	@RequestMapping(value="/countdown")
	public String countdown()
	{
		return "countdown";
	}
	
	@RequestMapping(value="/header.html")
	public String gotoheader() {
		
		return "header";
		
	}
	
	@RequestMapping(value="index")
	public String indexpage() {
		
		return "index";
	}
	
	
	@RequestMapping(value="searchbyAll",method=RequestMethod.POST)
	public ModelAndView searchall(@ModelAttribute("product")Product product,Model m) {
		System.out.println(product.getPname());
		String n=product.getPname();
		int flag=1;
		 Product p = productdao.getProductbyName(n);
		 System.out.println("Hello");
		  try{
		
			p.getPname();
		}
		catch(NullPointerException z){
			            System.out.println(flag);
			        	System.out.println("Not Found in Product Table");
          	            flag=0;
          	          	
		  }
          	
          	finally{
          		System.out.println(flag);
          		if(flag==0)
          		{
          			
          			p = productdao.setData(0, "NOT FOUND", "NOT FOUND", "0", "0");
          		}
          	}				
		 System.out.println("out");		
		return new ModelAndView("productdisplay","productdescription",p);
	}// end of search all
	
	


	
}
