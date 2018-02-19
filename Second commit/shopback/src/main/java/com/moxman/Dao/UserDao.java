package com.moxman.Dao;

import org.springframework.stereotype.Repository;

import com.moxman.model.User;

@Repository("userDAO")
public interface UserDao {

	public boolean adduserUser(User user);
}
