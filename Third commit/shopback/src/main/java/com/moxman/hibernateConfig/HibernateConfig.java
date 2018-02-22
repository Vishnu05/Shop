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

import com.moxman.model.*;


@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class HibernateConfig {
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2() {
		System.out.println("Hibernate initiated");
		DriverManagerDataSource dt=new DriverManagerDataSource();
		dt.setDriverClassName("org.h2.Driver");
		dt.setUrl("jdbc:h2:tcp://localhost/~/test0510");
		dt.setUsername("sa");
		dt.setPassword("");
		System.out.println("connection established");
		return dt;
	}
	private Properties getHiberProps(){
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.show_sql","true");
		p.put("hibernate.hbm2ddl.auto","update");
		return p;
	}
				
		
		
		
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransaction(SessionFactory sessionFactory) {
			
			HibernateTransactionManager tm=new HibernateTransactionManager(sessionFactory);
			return tm;
		}
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSession(DataSource datasource) {
			LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(datasource);
			lsfb.addProperties(getHiberProps());
			lsfb.addAnnotatedClass(User.class);
			lsfb.addAnnotatedClass(Cart.class);
		//	lsfb.addAnnotatedClass(Order.class);
			lsfb.addAnnotatedClass(orders.class);
			lsfb.addAnnotatedClass(Product.class);
			lsfb.addAnnotatedClass(Category.class);
			lsfb.addAnnotatedClass(Subcategory.class);
			lsfb.addAnnotatedClass(shipping_address.class);
			
			return lsfb.buildSessionFactory();
		}		
		
	}


	

	