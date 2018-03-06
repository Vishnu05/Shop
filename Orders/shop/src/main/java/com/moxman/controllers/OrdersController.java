package com.moxman.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.SortComparator;
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

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class OrdersController {

	@Autowired
	OrderDAO orderdao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	CartDAO cartdao;
/* 
	@RequestMapping(value="/check_orders",method=RequestMethod.GET)
	public String insertorders(HttpSession session,Model m) {
	  	System.out.println("---Orders---");
		String email=(String)session.getAttribute("email");
	//	User email=userdao.getemail(email);
		
		Orders o=new Orders();
		Cart c=new Cart();
	//	Cart c=(Cart)cartdao.retrive(email);
				
		c.getEmail();
		c.getProdname();
		c.getPrice();
		c.getQuantity();
		c.getPimage();
		
		o.setEmail(c.getEmail());
		o.setProdname(c.getProdname());
		o.setPrice(c.getPrice());
		o.setQuantity(c.getQuantity()); 
		o.setPimage(c.getPimage()); 
	//	System.arraycopy(email, 0, session, 0, 0);
		
		System.out.println(c.getEmail());
		System.out.println(c.getProdname());
		System.out.println(c.getPrice());
		
		List<Orders> list=orderdao.getallorders();
		m.addAttribute("orderitems",list);
	 	//orderdao.addorder(o);
		
		return "orders";
	}

*/ 
	
//	@RequestMapping(value="/check_orders")
//	public String orderspage(Model m,HttpSession session) {
//		
//		
//		return "orders";
//	}
	
 
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
	norder.setEmail(email);  
	orderdao.addorder(norder); 
	m.addAttribute("user", user);
	m.addAttribute("grandtotal", grandtotal);
	m.addAttribute("orderitems", list);
	
	return "orders";
	}
 
}
