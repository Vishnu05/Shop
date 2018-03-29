package com.moxman.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/check_orders/{total}", method = RequestMethod.GET)
	public String orderspage(@PathVariable("total") float total, HttpSession session, Model m) {

		String email = (String) session.getAttribute("email");
		List<Cart> list = cartdao.retrive(email);
		Cart ncar = list.get(0); //new Cart(); 
		User user = userdao.getemail(email);

		float grandtotal = total;

		Orders norder = new Orders();
		norder.setTotal(grandtotal);
		norder.setEmail(email);
		
		norder.setQuantity(ncar.getQuantity()); System.out.println("---------------Order Quantity---------------"+ncar.getQuantity());
		// norder.set
		// .setCartit(ncar.getCartid());
		System.out.println("");
		norder.setCitemid(ncar.getCitemid());
		norder.setProdname(ncar.getProdname());
		norder.setPrice(ncar.getPrice());
		norder.setEmail(email);
		orderdao.addorder(norder);
		//orderdao.reteriveorders(email);
		List<Orders> list1=orderdao.reteriveorders(email);
		m.addAttribute("orderitems",list);
		m.addAttribute("user", user);
		m.addAttribute("grandtotal", grandtotal);
		m.addAttribute("orderitems", list1);

		return "redirect:/orders";
	}

	@RequestMapping("/orders")
	public String gotoorders(Model m, HttpSession session) {

		String email = (String) session.getAttribute("email");
		
		System.out.println("--User --" + email);
		List<Orders> list1 = orderdao.reteriveorders(email);
	
		// List<Orders> list=orderdao.getallorders();
		m.addAttribute("orderitems", list1);
		return "orders";

	}

	@RequestMapping(value="/adminorders")
	public String adminorders(Model m,HttpSession session) {

		String email=(String)session.getAttribute("email");
		User user=userdao.getemail(email);
		if(user.getRole().equals("Role_admin")) {
		System.out.println(""+user.getRole());
		List<Orders> list = orderdao.getallorders();
	 
	
		m.addAttribute("orderitems", list);
		return "orders";
	}
		else {
			return	"admin";	
		}
		
	}
	
//	@RequestMapping(value="/deleteorder/{orderid}",method=RequestMethod.GET)
//	public String deleteorder(@RequestParam int orderid ,Model m,HttpSession session) {
//		
//		String email=(String)session.getAttribute("email");
//		Orders order=orderdao.removeorder(orderid);
//		
//		
//		return "";
//	}
	
} 
