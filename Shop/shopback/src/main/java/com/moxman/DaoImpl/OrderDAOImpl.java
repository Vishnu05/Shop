package com.moxman.DaoImpl;


import java.util.List;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.moxman.Dao.*;
import com.moxman.model.Cart;
import com.moxman.model.Orders;
import com.moxman.model.Product;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	SessionFactory sessionf;

	public void addorder(Orders o) {
		
		Session session=sessionf.openSession();
		session.beginTransaction();
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

		public void removeorder(int orderid) {
			

			Session session=sessionf.openSession();
			session.beginTransaction();
			Query query=session.createQuery("delete from Orders where orderid=?");
			query.setParameter("orderid",  orderid);
			
			
			
		}
	 

		

}
