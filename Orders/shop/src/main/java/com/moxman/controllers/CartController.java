package com.moxman.controllers;

 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.OrderColumn;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moxman.DaoImpl.CartDAOImpl;
import com.moxman.DaoImpl.ProductDAOImpl;
import com.moxman.DaoImpl.UserDaoImpl;
import com.moxman.model.Cart;
import com.moxman.model.Product;
import com.moxman.model.User;

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
				p.setCatid(0);   
				p.setDescription("Not Found");    
				p.setPid(0);     
				p.setPname("Not Found");   
				p.setPprice("0");               
				p.setQuantity("0");  
			}
		}

		System.out.println("----"+cart.getProid());
		System.out.println("----"+cart.getProdname());
		System.out.println("----"+cart.getPrice());
		System.out.println("---"+cart.getQuantity());

		
		cart.setProid(p.getPid());
		cart.setProdname(p.getPname());
		cart.setPrice(p.getPprice());  
		cart.setPimage(p.getPimage());
		cart.setQuantity("1");
		
		System.out.println("----"+cart.getProid());
		System.out.println("-----"+cart.getProdname());
		System.out.println("---"+cart.getPrice());
		System.out.println("----"+cart.getQuantity());

		List<Cart> list =cartdaoimpl.retrive(email); 
		m.addAttribute("cartitems", list);
		cartdaoimpl.insertCart(cart);
		return new ModelAndView("redirect:/cart");
	}

  
 	
	 @RequestMapping(value="/cart",method=RequestMethod.GET)
	 public String cartdisplay(HttpSession session,Model m) {
		 
		 String email=(String)session.getAttribute("email");
		 List<Cart>list=cartdaoimpl.retrive(email);
		 m.addAttribute("cartitems",list);
		 
		 int  n=list.size();
		 if (n==0)
			 m.addAttribute("n", n);
		 
		 return "cart";
		 
	 }
 
	@RequestMapping(value="/deleteCartItem/{citemid}",method=RequestMethod.GET )
	public String deletecartitem(@PathVariable("citemid")int citemid,Model m,HttpSession session) {
		
		String email=(String)session.getAttribute("email");
		Cart cart=cartdaoimpl.getCart(citemid);
		cartdaoimpl.removeCart(cart);
		
		List<Cart> list=cartdaoimpl.retrive(email);
		m.addAttribute("cartitems",list);
		return "redirect:/cart";
	}
	
	@RequestMapping(value ="/addquty/{val}/{pname}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void checkUsername(@PathVariable("val") String val,@PathVariable("pname") String pname,@PathVariable("id") int id, HttpServletResponse response ,HttpSession session,HttpServletRequest request) throws IOException {
        
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String email=(String)session.getAttribute("email");
	    System.out.println(val);
	    System.out.println(pname);
	    cartdaoimpl.setQuantity(email, pname, val, id);
	    System.out.println("SUCESSFULLY SET");  
	    
	    
	}
	
	
}
