package com.moxman.Dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.moxman.model.*;

@Repository("orderDAO")
public interface OrderDAO {
	
	 void addorder(Orders order);
	 void removeorder(String email);
	 List<Orders> getallorders();
	 Orders getorderid(int orderid);
	 void reteriveorders(String email);
	 

}
