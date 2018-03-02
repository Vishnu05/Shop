package com.moxman.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moxman.Dao.OrderDAO;
import com.moxman.Dao.UserDao;
import com.moxman.model.*;

@Controller
public class OrdersController {

	@Autowired
	OrderDAO orderdao;
	
	@Autowired
	UserDao userdao;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String insertorders(HttpSession session,Model m) {
	  	
		String email=(String)session.getAttribute("email");
		Orders o=new Orders();
		Cart c=new Cart();
		o.setEmail(c.getEmail());
		o.setProdname(c.getProdname());
		o.setPrice(c.getPrice());
		o.setQuantity(c.getQuantity());
		o.setPimage(c.getPimage());
		
		List<Orders> list=orderdao.getallorders();
		m.addAttribute("",list);
	//	orderdao.addorder(order);
		
		return " ";
	}
	
	@RequestMapping(value="/orders")
	public String myorders(HttpSession session, Model m) {
		
		
		return "orders";
	}
	
}
