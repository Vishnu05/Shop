package com.moxman.Dao;

import org.springframework.stereotype.Repository;

import com.moxman.model.User;

@Repository()
public interface UserDao {

	public boolean adduserUser(User user);
}
