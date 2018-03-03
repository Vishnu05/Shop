package com.moxman.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moxman.Dao.UserDao;
 
import com.moxman.model.*;
 

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionF;

	// public UserDaoImpl(SessionFactory sessionFactory)
	// {
	// super();
	// sessionF=sessionFactory;
	//
	// }

	/**
	 * @Transactional public boolean adduserUser(User user) { try { Session
	 *                session=sessionF.openSession(); session.beginTransaction();
	 *                session.persist(user); session.getTransaction().commit();
	 *                session.close();
	 * 
	 *                return true; } catch(Exception e) {
	 * 
	 *                System.out.println("error"+e.getMessage()); return false; }
	 * 
	 *                }
	 */
	
	

	public void createuser(User user) {

		Session session = sessionF.openSession();
		session.beginTransaction();
		session.persist(user);
		System.out.println(user);
		session.getTransaction().commit();
		session.close();

		// Session session=sessionF.getCurrentSession();
		// session.save(user);
	}

	public void creatshipadd(Shipment ship) {

		Session session = sessionF.openSession();
		session.beginTransaction();
		session.persist(ship);
		session.getTransaction().commit();
		session.close();

	}
	
//	@SuppressWarnings("unchecked")
//	public List<User> getemaila(String email) {
//		Session session=sessionF.openSession();
//		session.beginTransaction();
//		User user=(User)session.load(User.class,new String(email));
//		System.out.println("Email list"+user);
//		session.getTransaction().commit();
//		session.close();
//		return "User";
//	}

	public User getemail(String email) {
		Session session=sessionF.openSession();
		session.beginTransaction();
		User user=(User)session.load(User.class, new String(email));
		System.out.println("---email---"+user+" "+email);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	public List<User> getalluser() {
		 		return null;
	}

	public void updateuser(User user) {
		
		Session session=sessionF.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();	
	}

}
