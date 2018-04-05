package com.moxman.DaoImpl;


import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.omg.CORBA.TRANSIENT;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.event.TransactionalEventListener;

import com.moxman.Dao.*;
import com.moxman.model.*;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	SessionFactory sessionf;

	public void addorder(Orders o) {
		
		Session session=sessionf.openSession();
		session.beginTransaction();
		o.setOrderdate(new Date());
		session.persist(o);
		session.getTransaction().commit();
		session.close();
		
	}

	public void removeorder(String email) {
		
		Session session=sessionf.openSession();
		session.beginTransaction();
		session.delete(email);
		session.getTransaction().commit();
		session.close();
		
	}
	
	 
	public List<Orders> getallorders() {
		
		Session session=sessionf.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Orders> orderslist=session.createQuery("from Orders").list();
		session.getTransaction().commit();
		session.close();
		return orderslist;
	 
	}

        public Orders getorderid(int orderid) {
		 
		Session session=sessionf.openSession();
		session.beginTransaction();
		Orders order=session.load(Orders.class,new Integer(orderid));
		System.out.println("--ORDERS--" + order);
		session.getTransaction().commit();
		session.close();
		return order;
	}

		public List<Orders> reteriveorders(String email) {
			 
			Session session=sessionf.getCurrentSession();
			@SuppressWarnings("rawtypes")
			Query query=session.createQuery("from Orders where email=:email");
			query.setParameter("email", email);
			@SuppressWarnings("unchecked")
			List<Orders> list=query.list();
			return list;
 	}

		


		
		public List<Orders> batch1(String email) {
			 
		
			Session session=sessionf.openSession();
			session.beginTransaction();
			Query query=session.createQuery("from Orders where orderdate between '2018-03-20 14:34:16' and '2018-03-26 15:16:16'");
			List<Orders> list=query.list();
			session.getTransaction().commit();
			session.close();
 		
			
//			@SuppressWarnings("unchecked")
//			List<Orders> list=query.list();
			
			return list;
		}
	 
		public void removeorder(Orders order) {

			Session session=sessionf.openSession();
			session.beginTransaction();
			session.delete(order);
			session.getTransaction().commit();
			session.close();		
		}

		
		public List<Orders> batch2(String email) {
			// TODO Auto-generated method stub
			return null;
		
		}
  
}
