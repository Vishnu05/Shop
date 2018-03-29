package com.moxman.DaoImpl;


import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
//import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
			 
			Session session=sessionf.openSession();
			@SuppressWarnings("rawtypes")
			Query query=session.createQuery("from Orders where email=:email");
			query.setParameter("email", email);
			@SuppressWarnings("unchecked")
			List<Orders> list=query.list();
			return list;
 	}

		public List<Orders> batch1(String email) {
		
			Session session=sessionf.openSession();
			@SuppressWarnings("rawtypes")
			Query query=session.createQuery("from Orders where oderdate between '' and '' ");
			query.setParameter(1, email);
			query.setParameter(2, email);
			@SuppressWarnings("unchecked")
			List<Orders> list=query.list();
			
			
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

		
/*		public List<User> getListOfSuggestedUsers(String username) {
			
			Session session=sessionF.getCurrentSession();
			String queryString="select * from user_table where username in (select username from user_table where username!=? minus (select fromid from Friend where toid=? and status!='D' union select toid from Friend where fromid=? and status!='D'))";
			@SuppressWarnings("deprecation")
			SQLQuery query=session.createSQLQuery(queryString);
			query.setString(0,username);
			query.setString(1,username);
			query.setString(2,username);
			query.addEntity(User.class);
			List<User> obj=query.list();
			return obj;
		}
*/		 
		

		
	 
		
	


	 

		

}
