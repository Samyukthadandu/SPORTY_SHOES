package com.simplilearn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.dao.EntityDAO;
import com.simplilearn.model.Product;
import com.simplilearn.model.Reports;
import com.simplilearn.model.Users;
import com.simplilearn.model.Customer;

@Controller
public class ReportController {
	
	@Autowired
	private EntityDAO entityDAO;
	
	
	@RequestMapping("/reportRequest")
	public ModelAndView rhandleRequest() throws Exception {
	   // List<Users> listUsers = userDao.list();
	  
		ModelAndView model = new ModelAndView("Reports");
	   // model.addObject("userList", listUsers);
	    System.out.println("Mapping working");
	    return model;
	}
	
	@RequestMapping(value = "/purchase-reports", method = RequestMethod.GET)
	public ModelAndView purchasereports(HttpServletRequest request) {
		
		
		System.out.println("I'm in purchase reports");
		
        List<Reports> r = entityDAO.purchaseReports();
	
	    ModelAndView model = new ModelAndView("Reports");
	    model.addObject("purchasereport", r);
	    
	   // System.out.println("Im in cat gender method");
	    return model;      
	}
	
	@RequestMapping(value = "/all-customers", method = RequestMethod.GET)
	public ModelAndView allCUSTOMERS(HttpServletRequest request) {
		
		
		System.out.println("I'm all users");
		
        List<Customer> c = entityDAO.allcustomers();
	
	    ModelAndView model = new ModelAndView("Customer");
	    model.addObject("customers", c);
	    
	   // System.out.println("Im in cat gender method");
	    return model;      
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchCust(@RequestParam("t1") String custName) {
		System.out.println("in searchuser method" + custName);
		List<Reports> ob = entityDAO.searchCustomer(custName);
		ModelAndView model = new ModelAndView("RepDisplay");
		if(ob!=null) {
		 
		    model.addObject("reportdisplay", ob);
		}else{
			// model.setViewName("RepDisplay");			   
			model.addObject("msg", "This Customer Signed-In  but did no purchase");
		}
	    return model;
	}  
	
	@RequestMapping(value = "/dashpg", method = RequestMethod.POST)
	public ModelAndView dashb(HttpServletRequest request) {
	    ModelAndView model = new ModelAndView("Dashboard");	  
	    return model;      
	}

}
