package com.simplilearn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import java.util.List;

import com.simplilearn.model.*;



@Repository
public class EntityDAOImple implements EntityDAO{	
	
	
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	    public EntityDAOImple() {
	         
	    }
	     
	    public EntityDAOImple(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    
	    // Method implementation of AdminLogin Validation and Admin Change Password

     public int checkLogin(String userName, String userPassword)
             
            {    	 
			System.out.println("In Check login"+ userName +userPassword);
			Session session = sessionFactory.openSession();
			int userFound = 0;
			//Query using Hibernate Query Language
			String SQL_QUERY =" select userId from Users as o where o.userName=? and o.userPassword=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				//userFound= true;
				userFound=(Integer)list.get(0);
				System.out.println("UserID"+ userFound);				
			}

			session.close();
			return userFound;              
            }    
       
     
     @Override
	    @Transactional
	    public void saveOrUpdate(Users user) {
    	   System.out.println("im in dao imple");
	        sessionFactory.getCurrentSession().saveOrUpdate(user);
	    }
     
  
     
     @Override
	    @Transactional
	    public Users get(int userId) {
	        String hql = "from Users where userId=" + userId;
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	         
	        @SuppressWarnings("unchecked")
	        List<Users> listUser = (List<Users>) query.list();
	         
	        if (listUser != null && !listUser.isEmpty()) {
	        	System.out.println(listUser.get(0));
	            return listUser.get(0);
	            
	        }
	         
	        return null;
	    }
     
     // Below are the methods implemented for Product Management by ADMIN
     
     @Override
	    @Transactional
	    public List<Product> list() {
	        @SuppressWarnings("unchecked")
	        List<Product> pList = (List<Product>) sessionFactory.getCurrentSession()
	                .createCriteria(Product.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	 
	        return pList;
	    }
	    
	     @Override
	    @Transactional
	    public void PsaveOrUpdate(Product p) {
	        sessionFactory.getCurrentSession().saveOrUpdate(p);
	    }
	 
	    @Override
	    @Transactional
	    public void deletePID(int id) {
	        Product productToDelete = new Product();
	        productToDelete.setProductID(id);
	        sessionFactory.getCurrentSession().delete(productToDelete);
	    }
	 
	    @Override
	    @Transactional
	    public Product getPID(int id) {
	        String hql = "from Product where productID=" + id;
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
	         
	        @SuppressWarnings("unchecked")
	        List<Product> list = (List<Product>) query.list();
	         
	        if (list != null && !list.isEmpty()) {
	            return list.get(0);
	        }
	         
	        return null;
	    }
	    
	    @Override
	    @Transactional
	    public List<Product> catGender(String ch) {
	    	 String hql = "from Product where category= '"  +ch+"'";
	    	 
	    	 System.out.println(hql);
	    	 Query query = sessionFactory.getCurrentSession().createQuery(hql);
	    	// query.setParameter("c",ch);
	    	 
	    	System.out.println("size"+ query.list().size());
	    	
	    	 @SuppressWarnings("unchecked")
		        List<Product> list = (List<Product>) query.list();
	    	 
	    	System.out.println("array size"+ list.size());
		         
		        if (list != null && !list.isEmpty()) {
		        	
		        	System.out.println("inside if condition"+ list.size());
		            return list;       //.get(0);
		        }
		        System.out.println("after if condition"+ list.size());
		        return null;
	    	
	    }
	    
	    @Override
	    @Transactional
	    public List<Reports> purchaseReports() {
	    	 String hql = "from Reports";
	    	 
	    	 System.out.println(hql);
	    	 Query query = sessionFactory.getCurrentSession().createQuery(hql);
	    	
	    	 
	    	System.out.println("size"+ query.list().size());
	    	
	    	 @SuppressWarnings("unchecked")
		        List<Reports> list = (List<Reports>) query.list();
	    	 
	    	System.out.println("array size"+ list.size());
		         
		        if (list != null && !list.isEmpty()) {
		        	
		        	System.out.println("inside if condition of Reports"+ list.size());
		            return list;       //.get(0);
		        }
		       // System.out.println("after if condition"+ list.size());
		        return null;
	    	
	    }
	    
	    @Override
	    @Transactional
	    public List<Customer> allcustomers() {
	    	 String hql = "from Customer";
	    	 
	    	 System.out.println(hql);
	    	 Query query = sessionFactory.getCurrentSession().createQuery(hql);
	    	
	    	 
	    	System.out.println("size"+ query.list().size());
	    	
	    	 @SuppressWarnings("unchecked")
		        List<Customer> list = (List<Customer>) query.list();
	    	 
	    	System.out.println("array size"+ list.size());
		         
		        if (list != null && !list.isEmpty()) {
		        	
		        	System.out.println("inside if condition of customers"+ list.size());
		            return list;       //.get(0);
		        }
		       // System.out.println("after if condition"+ list.size());
		        return null;
	    	
	    }
	    
	    @Override
	    @Transactional
	    public List<Reports> searchCustomer(String custName) {
	    	
	    	 String hql = "from Reports where customer ='"+custName+"'";
	    	 
	    	 System.out.println(hql);
	    	 Query query = sessionFactory.getCurrentSession().createQuery(hql);
	    	
	    	 
	    	System.out.println("size"+ query.list().size());
	    	
	    	 @SuppressWarnings("unchecked")
		        List<Reports> list = (List<Reports>) query.list();
	    	 
	    	System.out.println("array size"+ list.size());
		         
		        if (list != null && !list.isEmpty()) {
		        	
		        	System.out.println("inside if condition of searchcustomers"+ list.size());
		            return list;
		        }
		       // System.out.println("after if condition"+ list.size());
		        return null;
	    	
	    }
	    	
	    
	    


}
