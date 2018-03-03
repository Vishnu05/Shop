package com.moxman.DaoImpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.moxman.Dao.*;
import com.moxman.model.*;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFac;
	
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
		
	}	
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory()
	{
		Session session = sessionFac.openSession();
		session.beginTransaction();
		List<Category> catlist = session.createQuery("from Category").list();
		session.getTransaction().commit();
		session.close();
		return catlist;
		
	}
	
	
	public Category getCategorybyID(int ID)
	{
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		Category c = (Category) session.load(Category.class,new Integer(ID));
		System.out.println("===================> p =" +c);
		session.getTransaction().commit();
		session.close();
		return c;
	}
	
	public Category getCategorybyName(String Name)
	{
		String hql = "FROM Category c  where c.NAME = :Name";
		Session session=sessionFac.openSession();	
		Query query = session.createQuery(hql);
		query.setParameter("Name",Name);
		session.beginTransaction();
		Category c = (Category) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return c;
	}
	
	public void createCategory(Category category){
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateCategory(Category category)
	{
		System.out.println("-------------------------------->bread details in dao : "+category.getCatid());
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.update(category);
		System.out.println("----------------------------> updated------------------------------>");
		session.getTransaction().commit();
		System.out.println("-----------------------------> committed---------------------------->");
		//session.flush();
		System.out.println("---------------------------------> session is closing-------------------->");
		session.close();
	}
	
	public void deleteCategory(Category category)
	{
		Session session=sessionFac.openSession();	
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
		session.close();
	}
	


}
