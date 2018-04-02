package com.moxman.DaoImpl;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.moxman.Dao.*;
import com.moxman.model.*;

@Repository
public class SubcategoryDAOImpl implements SubcategoryDAO {
	
	@Autowired
	SessionFactory sessionFac;
	
	public SubcategoryDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
	
	@SuppressWarnings("unchecked")
	public List<Subcategory> getAllSubcategory()
	{
		Session session = sessionFac.openSession();
		session.beginTransaction();
		List<Subcategory> subcatlist = session.createQuery("from Subcategory").list();
		session.getTransaction().commit();
		session.close();
		return subcatlist;
		
	}
	
	
	public Subcategory getSubcategorybyID(int ID)
	{
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		System.out.println(ID);
		Subcategory c = (Subcategory) session.load(Subcategory.class,new Integer(ID));
		System.out.println("===================> p =" +c);
		session.getTransaction().commit();
		session.close();
		return c;
	}
	
	public Subcategory getSubcategorybyName(String Name)
	{
		String hql = "FROM SubCategory c  where c.NAME = :Name";
		Session session=sessionFac.openSession();	
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("Name",Name);
		session.beginTransaction();
		Subcategory c = (Subcategory) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return c;
	}
	
	public void createSubcategory(Subcategory subcategory){
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		subcategory.setSubcatdate(new Date());
		session.persist(subcategory);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateSubcategory(Subcategory subcategory)
	{
		//System.out.println("-------------------------------->bread details in dao : "+subcategory.getCatid());
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.update(subcategory);
		System.out.println("----------------------------> updated------------------------------>");
		session.getTransaction().commit();
		System.out.println("-----------------------------> committed---------------------------->");
		//session.flush();
		System.out.println("---------------------------------> session is closing-------------------->");
		session.close();
	}
	
	public void deleteSubcategory(Subcategory subcategory)
	{
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.delete(subcategory);
		session.getTransaction().commit();
		session.close();
	}




}
