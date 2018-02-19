package com.moxman.controllers;

import javax.persistence.OrderColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moxman.DaoImpl.CartDAOImpl;
import com.moxman.DaoImpl.ProductDAOImpl;
import com.moxman.DaoImpl.UserDaoImpl;
import com.moxman.model.Cart;

@Controller
public class CartController {

	@Autowired
	CartDAOImpl cartdaoimpl;
	
	//@Autowired
	//UserDaoImpl userdaoimpl;
	
	@Autowired
	ProductDAOImpl productdaoimpl;
	
	
	
	@RequestMapping(value="/insertcart")
	public String insertcart() {
		
		Cart cart=new Cart();
		cart.getCitemid();
		cartdaoimpl.insertCart(cart);
		
		return "";
	}
	
	@RequestMapping("value=cart")
	public String showcart(Model m) {
		
		Cart cart=new Cart();
		m.addAttribute("cartlist",cart);
		return "cart";
		
		
	}
	
	
}
