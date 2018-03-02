package com.moxman.DaoImpl;


import java.util.List;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.moxman.Dao.*;
import com.moxman.model.Orders;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	SessionFactory sessionf;

	public void addorder(Orders order) {
		
		Session session=sessionf.openSession();
		session.beginTransaction();
		session.persist(order);
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
		 
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from orders where email=:email ");
		@SuppressWarnings("unchecked")
		List<Orders> list=query.list();
		return list;
	}
	 
	
	
		

}
