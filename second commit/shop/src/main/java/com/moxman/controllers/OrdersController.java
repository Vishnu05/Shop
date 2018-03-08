package com.moxman.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moxman.Dao.CartDAO;
import com.moxman.Dao.OrderDAO;
import com.moxman.Dao.UserDao;
import com.moxman.model.*;

@Controller
public class OrdersController {

	@Autowired
	OrderDAO orderdao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	CartDAO cartdao;
 
	@RequestMapping(value="/check_orders/{total}",method=RequestMethod.GET)
	public String orderspage(@PathVariable("total") float total,HttpSession session,Model m) {
		
	String email=(String)session.getAttribute("email");
	List<Cart> list=cartdao.retrive(email);
	Cart ncar =new Cart();        //           list.get(0);
	User user =userdao.getemail(email); 
	 
	float grandtotal=total;
	
	Orders norder = new Orders();
	norder.setTotal(grandtotal);
	norder.setEmail(email);
	norder.setQuantity(ncar.getQuantity());
	//norder.set
	//.setCartit(ncar.getCartid());
	
	norder.setCitemid(ncar.getCitemid());
	norder.setProdname(ncar.getProdname());
	norder.setEmail(email);  
	orderdao.addorder(norder); 
	m.addAttribute("user", user);
	m.addAttribute("grandtotal", grandtotal);
	m.addAttribute("orderitems", list);
	
	return "orders";
	}
	
	
	@RequestMapping("/orders")
	public String gotoorders(Model m,HttpSession session) {
		
		String email=(String)session.getAttribute("email");
	//	Orders order=orderdao.reteriveorders(email);
		System.out.println("--Orders page--");
		//orderdao.getallorders();
		List<Orders> list=orderdao.getallorders(); 
		m.addAttribute("orderitems",list);
		return "orders";
	
	}

		
// 
//	@RequestMapping
//	public String adminorder() {
//		
//		return "";
//	}
//	
	
	 
	
}

