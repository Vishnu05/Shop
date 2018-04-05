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

	@RequestMapping(value = "/check_orders/{total}", method = RequestMethod.GET)
	public String orderspage(@PathVariable("total") float total, HttpSession session, Model m) {

		String email = (String) session.getAttribute("email");
		List<Cart> list = cartdao.retrive(email);

		Cart ncar = list.get(0); // new Cart();
		User user = userdao.getemail(email);
		System.out.println(user);
		float grandtotal = total;

		Orders norder = new Orders();
		norder.setTotal(grandtotal);
		norder.setEmail(email);

		norder.setQuantity(ncar.getQuantity());
		System.out.println("---------------Order Quantity---------------" + ncar.getQuantity());
		System.out.println("");
		norder.setPimage(ncar.getPimage());
		norder.setCitemid(ncar.getCitemid());
		norder.setProdname(ncar.getProdname());
		norder.setPrice(ncar.getPrice());
		norder.setEmail(email);
		orderdao.addorder(norder);
		List<Orders> list1 = orderdao.reteriveorders(email);

		m.addAttribute("orderitems", list1);

		return "redirect:/orders";
	}

	@RequestMapping(value = "/orderslist", method = RequestMethod.GET)
	public String cartdisplay(HttpSession session, Model m) {

		String email = (String) session.getAttribute("email");
		List<Cart> list = cartdao.retrive(email);
		m.addAttribute("cartitems", list);

		int n = list.size();
		if (n == 0)
			m.addAttribute("n", n);

		return "cart";

	}

	@RequestMapping("/orders")
	public String gotoorders(Model m, HttpSession session) {

		String email = (String) session.getAttribute("email");

		System.out.println("--User --" + email);
		List<Orders> list1 = orderdao.reteriveorders(email);

		int n = list1.size();
		if (n == 0) {
			m.addAttribute("n", n);
		}

		// List<Orders> list=orderdao.getallorders();
		m.addAttribute("orderitems", list1);
		return "orders";

	}

	@RequestMapping(value = "/adminorders")
	public String adminorders(Model m, HttpSession session) {

		String email = (String) session.getAttribute("email");
		User user = userdao.getemail(email);
		if (user.getRole().equals("Role_Admin")) {
			List<Orders> list = orderdao.getallorders();

			m.addAttribute("orderitems", list);
			return "orders";
		}
		return "admin";
	}

	@RequestMapping(value = "/deleteorder/{orderid}", method = RequestMethod.GET)
	public String deleteitems(@PathVariable("orderid") int orderid, Model m, HttpSession session) {

		System.out.println("Going to start deleting ");
		Orders order = orderdao.getorderid(orderid);
		orderdao.removeorder(order);
		List<Orders> list = orderdao.getallorders();
		m.addAttribute("orderitems", list);
		System.out.println("googe deleting");

		return "redirect:/orders";

	}

//	@RequestMapping(value = "/adminorders")
//	public String adminorders(Model m, HttpSession session) {
//
//		String email = (String) session.getAttribute("email");
//		User user = userdao.getemail(email);
//		if (user.getRole().equals("Role_Admin")) {
//			List<Orders> list = orderdao.getallorders();
//
//			m.addAttribute("orderitems", list);
//			return "orders";
//		}
//		return "admin";
//	}
	
	
	
	@RequestMapping(value = "/getorders", method = RequestMethod.GET)
	public String batch1(Model m, HttpSession session) {

		String email = (String) session.getAttribute("email");
		User user = userdao.getemail(email);
		// if (user.getRole().equals(email)) {
		Orders order = new Orders();

		 List<Orders> list = orderdao.batch1(email);
		 m.addAttribute("vat", list);
		 m.addAttribute(order);

		 
		return "getorderstest";
	}

	// @RequestMapping(value="/")

}
