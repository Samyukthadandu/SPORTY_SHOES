package com.simplilearn.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.simplilearn.dao.EntityDAO;
import com.simplilearn.dao.EntityDAOImple;
import com.simplilearn.model.Users;
import com.simplilearn.model.Product;
import com.simplilearn.model.Reports;
import com.simplilearn.model.Customer;




@EnableWebMvc
@Configuration
@ComponentScan("com.simplilearn")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	//Configuring Spring MVC View Resolvers
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/views/");
	    
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}
	

	//Configuring DataSource Bean
	@Resource(name="jdbc/sportyshoesdb")
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource(
	    		);
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/sportyshoesdb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("sqlsam81");
	 
	    return dataSource;
	}
	
	// Configuring Session bean factory
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	 
	    sessionBuilder.addAnnotatedClasses(Users.class , Product.class , Reports.class , Customer.class);
	  //  sessionBuilder.addAnnotatedClasses(Product.class);
	 
	    return sessionBuilder.buildSessionFactory();
	}
	
	//getHibernateProperties() method is implemented as followings:
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	
	//Configuring TransactionManager Bean
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
	
	//Configuring DAO Bean
	
	@Autowired
	@Bean(name = "entityDAO")
	public EntityDAO getEntityDAO(SessionFactory sessionFactory) {
	    return new EntityDAOImple(sessionFactory);
	}
	
	


}
