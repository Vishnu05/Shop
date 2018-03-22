package com.moxman.hibernateConfig;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.moxman.model.Cart;
import com.moxman.model.Category;
import com.moxman.model.Coupons;
import com.moxman.model.Orders;
import com.moxman.model.Product;
import com.moxman.model.Shipment;
import com.moxman.model.Subcategory;
import com.moxman.model.User;


 

@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class HibernateConfig 
{
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource driverMgrDataSource=new DriverManagerDataSource();
		driverMgrDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverMgrDataSource.setUrl("jdbc:mysql://localhost:3306/shop?useSSL=false");
		
		driverMgrDataSource.setUsername("root");
		driverMgrDataSource.setPassword("1234");
		return driverMgrDataSource;
	}
	 
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		
		LocalSessionFactoryBuilder localSessionFacBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		localSessionFacBuilder.addProperties(hibernateProperties);
		localSessionFacBuilder.addAnnotatedClass(User.class);
		localSessionFacBuilder.addAnnotatedClass(Category.class);
		localSessionFacBuilder.addAnnotatedClass(Product.class);
		localSessionFacBuilder.addAnnotatedClass(Shipment.class);
		localSessionFacBuilder.addAnnotatedClass(Subcategory.class);
		localSessionFacBuilder.addAnnotatedClass(Cart.class);
		localSessionFacBuilder.addAnnotatedClass(Orders.class);
		localSessionFacBuilder.addAnnotatedClass(Coupons.class);
	 	SessionFactory sessionFactory=localSessionFacBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}
	 
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTranMgr=new HibernateTransactionManager(sessionFactory);
		return hibernateTranMgr;
	}
	
}




