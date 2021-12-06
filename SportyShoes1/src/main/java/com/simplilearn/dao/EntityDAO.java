package com.simplilearn.dao;

import java.util.List;

import com.simplilearn.model.Product;
import com.simplilearn.model.Reports;
import com.simplilearn.model.Users;
import com.simplilearn.model.Customer;



public interface EntityDAO {
	
	
	// The below methods are for Admin Login Validation and his Password Change
	   public Users get(int id);
	
	   public int checkLogin(String userName, String userPassword);	
	 
	   public void saveOrUpdate(Users user); 
	
	   
	 
	 // The below methods are for Product management by the Admin
	 
	     public List<Product> list();
	     
		 public Product getPID(int id);
		 
		 public void  deletePID(int pID);
		
		 public void PsaveOrUpdate(Product p);
		 
		 public List<Product> catGender(String ch);
		 
		 // The below methods are for seeing purchseorder reports by admin
		 
		 public List<Reports> purchaseReports();
		 
		// The below methods are for seeing signed-in customers
		 
				 public List<Customer> allcustomers();		 
		 
	    // The below method is for searching customer purchase report
				 
				 public List<Reports> searchCustomer(String custName);	 
	
	 
	
}
