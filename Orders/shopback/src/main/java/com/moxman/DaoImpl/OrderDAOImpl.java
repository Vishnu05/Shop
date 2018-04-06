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

		


		
		public List<Orders> batch1(String email,String fromdate, String todate){
			 
		
			Session session=sessionf.openSession();
			session.beginTransaction();
			String querystring = "from Orders where orderdate between '"+ fromdate + "' and '" + todate + "'";
			System.out.println(querystring);
			Query query=session.createQuery(querystring);  
			 
			// how to pass the date here no need of converting the date if we just pass it in that ? mark the data will be reterived //okay
			//from where do you callt from controller to here
			/*
			 * it is just warning no worries Nod da that is the command to execute queres?
			 * yeah da what to do now do you know what is suppress warning? yeah unchecked list ? i dont know
			 * ignore warnings for now. you can deal wiht them laterfine  */
			@SuppressWarnings("unchecked")
			List<Orders> list=query.list();
			session.getTransaction().commit();
			session.close();
 		//understood? yeah good da . thoo Test it now. with sample dates give me sample dates no records da it is in my office pc but there is table with data and date
			// wait ill import the table here and check this one 
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
