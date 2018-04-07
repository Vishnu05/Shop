package com.moxman.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ExcludeDefaultListeners;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moxman.Dao.CartDAO;
import com.moxman.Dao.UserDao;
import com.moxman.model.Coupons;
import com.moxman.model.Shipment;
import com.moxman.model.User;

 
@RestController
public class UserController2 {

	
	@Autowired
	UserDao userdao;
	
    @RequestMapping("/checkcouponid")
    public Response greeting(@RequestParam(value="couponid", defaultValue="") String name) {
    	
    	
    	List<Coupons> list=userdao.check(name);
    	System.out.println(name);
    	 
    	if(!list.isEmpty()){
    		return new Response(list.get(0).getPercent());
    	}
    	return new Response("Invalid");
            
}

class Response {
	String result = "";
	
	public Response(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
}
}