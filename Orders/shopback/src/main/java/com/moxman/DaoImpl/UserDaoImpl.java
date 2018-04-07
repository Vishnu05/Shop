package com.moxman.DaoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moxman.Dao.UserDao;
 
import com.moxman.model.*;
 

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionF;

		

	public void createuser(User user1) {

		Session session = sessionF.openSession();
		session.beginTransaction();
		user1.setUserdate(new Date());
		session.persist(user1);
		System.out.println(user1);
		session.getTransaction().commit();
		session.close();
	}
	

	public User getemail(String email) {
		Session session=sessionF.openSession();
		session.beginTransaction();
		User user=(User)session.load(User.class, new String(email));
		System.out.println("---email---"+user+" "+email);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	

	public void updateuser(User user) {
		
		Session session=sessionF.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();	
	}

	public List<User> getalluser() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void creatshipadd(Shipment ship) {

		Session session = sessionF.openSession();
		session.beginTransaction();
		ship.setShipdate(new Date());
		session.persist(ship);
		session.getTransaction().commit();
		session.close();

	}
	
	public void addcoupons(Coupons coupons) {
		
		Session session=sessionF.openSession();
		session.beginTransaction();
		coupons.setCoupondate(new Date());
		session.persist(coupons);
		session.getTransaction().commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<Coupons> getallcoups() {
		
		Session session=sessionF.openSession();
		session.beginTransaction();
		List<Coupons> couplist=session.createQuery("from Coupons").list();
		session.getTransaction().commit();
		session.close();
		
		return couplist;
	}


	public void deletecoup(Coupons coupons) {
	
		Session session=sessionF.openSession();
		session.beginTransaction();
		session.delete(coupons);
		session.getTransaction().commit();
		session.close();
	}


	public Coupons getcouponid(String id) {
		
		Session session=sessionF.openSession();
		session.beginTransaction();
		Coupons coup=(Coupons)session.load(Coupons.class,id);
		System.out.println("Coupon ID"+coup);
		session.getTransaction().commit();
		session.close();
		return coup;
	}

	public List<Coupons> check(String coupon){
		
		Session session=sessionF.openSession();
		session.beginTransaction();
		String queryString="from Coupons where couponid='"+coupon+"'" ;
		
		Query coupons =session.createQuery(queryString);
		List<Coupons> list=coupons.list();
		session.getTransaction().commit();
		session.close();
	
		return list;
	}
}
