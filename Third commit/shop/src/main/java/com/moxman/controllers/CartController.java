package com.moxman.controllers;

import java.util.List;

import javax.persistence.OrderColumn;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.moxman.DaoImpl.CartDAOImpl;
import com.moxman.DaoImpl.ProductDAOImpl;
import com.moxman.DaoImpl.UserDaoImpl;
import com.moxman.model.Cart;
import com.moxman.model.Product;

@Controller
public class CartController {

	@Autowired
	CartDAOImpl cartdaoimpl;
   
	@Autowired
	UserDaoImpl userdaoimpl;

	@Autowired
	ProductDAOImpl productdaoimpl;

	@RequestMapping("/mycart")
	public String gotoCart() {
		return "cart";
	}
 

 	@RequestMapping(value = "/addcart/{name}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("name") String pname, HttpSession session, Model m) {
		Cart cart = new Cart();
		String email = (String) session.getAttribute("email");
		// Register u = userDAOImpl.getRegister(username);
		cart.setCartid(1000);
	//	cart.setStatus("N");
		cart.setEmail(email);
		System.out.println(pname);
		String n = pname;
		Product p = new Product();
		int flag = 1;

		p = productdaoimpl.getProductbyName(pname);  //getProductbyName(n);
		try {
			p.getPname();  //getProductName();
		} catch (NullPointerException e) {

			System.out.println("Not Found in Product Table");
			flag = 0;

		}

		finally {
			if (flag == 0) {
				p.setCatid(0);   //setCatId(0);
				p.setDescription("Not Found");   //setProductDesc("NOT FOUND");
				p.setPid(0);    // setProductId(0);
				p.setPname("Not Found");  //setProductName("NOT FOUND");
				p.setPprice("0");               //setPrice(0);
				p.setQuantity("0"); //(0);                             //setQuantity(0);
			}
		}

		cart.setProid(p.getPid());
		cart.setProdname(p.getPname());
		cart.setPrice(p.getPprice());  
		cart.setPimage(p.getPimage());
		cart.setQuantity("1");
		

		List<Cart> list =cartdaoimpl.retrive(email); 
		m.addAttribute("cartitems", list);
		cartdaoimpl.insertCart(cart);
		return new ModelAndView("redirect:/cart");
	}

// 	@RequestMapping(value="/cart",method=RequestMethod.GET)
//	public ModelAndView viewmycart(HttpSession session,Model m)
//	{
//	//	String username=(String)session.getAttribute("username");
//		//List<Cart>list=cartDAOImpl.retrive(username);
//		int n= list.size();
//		if(n==0)
//			m.addAttribute("n",n);
//		return new ModelAndView("cart","cartitems",list);
//		
//	}
 	
 	
	 @RequestMapping(value="/cart",method=RequestMethod.GET)
	 public String cartdisplay(HttpSession session,Model m) {
		 
		 String email=(String)session.getAttribute("email");
		 List<Cart>list=cartdaoimpl.retrive(email);
		 m.addAttribute("cartitems",list);
		 
		 return "cart";
		 
	 }
 
	
	

}
