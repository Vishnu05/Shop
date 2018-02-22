package com.moxman.DaoImpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moxman.Dao.*;
import com.moxman.model.*;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	SessionFactory sessionFac;
	 

		public OrderDAOImpl(SessionFactory sessionFactory)
		{
			super();
			sessionFac=sessionFactory;
			
		}	
		
		

}
