package com.moxman.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moxman.Dao.UserDao;
import com.moxman.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired                   
	private SessionFactory sessionF;

 /**	public UserDaoImpl(SessionFactory sessionFactory)
	{
		super();
		sessionF=sessionFactory;
	}
	
	*/
	public boolean adduserUser(User user) {
		try
		{ 
			Session session=sessionF.openSession();
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
			session.close();
			
			return true;
		}
		catch(Exception e) {
			
			System.out.println("error"+e.getMessage());
			return false;
		}
 
	}
	
	
} 
