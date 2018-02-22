package com.moxman.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.moxman.model.User;
import com.moxman.model.shipping_address;

@Repository("UserDa")
public interface UserDao {

	//public boolean adduserUser(User user);
	public void createuser(User user);
	public void creatshipadd(shipping_address ship);
	public User getemail(String email);
	public List<User> getalluser(String email);
}
