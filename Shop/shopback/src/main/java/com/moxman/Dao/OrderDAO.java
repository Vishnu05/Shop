package com.moxman.Dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.moxman.model.*;

@Repository("orderDAO")
public interface OrderDAO {
	
	 void addorder(Orders order);
	 void removeorder(int orderid);
	 List<Orders> getallorders();
	 Orders getorderid(int orderid);
	 List<Orders> reteriveorders(String email);
	 
}
