package com.moxman.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

 
import com.moxman.model.*;
 

@Repository("UserDa")
public interface UserDao {

	//public boolean adduserUser(User user);
	public void createuser(User fuck);
	public void creatshipadd(Shipment ship);
	public User getemail(String email);
	public List<User> getalluser();
	void updateuser(User user);
	void addcoupons(Coupons coupons);
	List<Coupons> getallcoups();
	
}
