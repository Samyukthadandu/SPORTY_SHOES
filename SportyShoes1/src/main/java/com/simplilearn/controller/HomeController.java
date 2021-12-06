package com.simplilearn.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.dao.EntityDAO;
import com.simplilearn.model.Product;
//import com.simplilearn.model.Product;
import com.simplilearn.model.Users;

import com.simplilearn.dao.EntityDAOImple;





@Controller
@SessionAttributes("userId")
//@RequestMapping("AdminUser")
public class HomeController {
	
	@Autowired
	private EntityDAO entityDAO;
	
	int globalId =0;
	String globaluName="";

	
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
	   // List<Users> listUsers = userDao.list();
	  
		ModelAndView model = new ModelAndView("Dashboard");
	   // model.addObject("userList", listUsers);
	    System.out.println("Mapping working");
	    return model;
	}
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView ValidateUser(@RequestParam("t1") String uName, @RequestParam("t2") String uPassword) {
	  //  String  uname = request.getParameter("userName");
	  //  String  pwd = request.getParameter("userPassword");	
	    System.out.println(uName+uPassword);
	    globaluName =uName;
	    
		
	    
	   int userexists= entityDAO.checkLogin(uName, uPassword);	   
	   System.out.println("UserID validate"+userexists );
	   globalId=userexists;
		ModelAndView model = new ModelAndView("Dashboard");
	    model.addObject("userId" , userexists);
	   if(userexists!=0) {	    	 
	     return model;     
	   }else {
		   model.setViewName("LoginForm");
		   model.addObject("Invalid", "Invalid Credentials");
		//return new ModelAndView("LoginForm"); 
		   return model;
		
            }
	 }
	
//}

	@RequestMapping(value="/options", method = RequestMethod.POST)
	
	public ModelAndView options(HttpServletRequest request) {
		
		/*System.out.println("Im inside view");
		int userId=globalId; //= Integer.parseInt(request.getParameter("id"));
		System.out.println(userId+"   globalId value in options");
	    Users user = entityDAO.get(userId);		
	    ModelAndView model = new ModelAndView("ChangePwd");
	    model.addObject("user", user);
	    System.out.println("Im here options");
	    return model; */ 
		
		if ("changePassword".equals(request.getParameter("b1"))) {
			
			System.out.println("Im inside Changepassword jsp");
			int userId=globalId;			//= Integer.parseInt(request.getParameter("id"));
			
			System.out.println(userId+"   globalId value in options");
		    Users user = entityDAO.get(userId);		
		    ModelAndView model = new ModelAndView("ChangePwd");
		    model.addObject("user", user);
		    System.out.println("Im here options");
		    return model;  				
		 }else if("productList".equals(request.getParameter("b2"))) {
			 System.out.println("Im inside productlist jsp");
			 
			 List<Product> pLists = entityDAO.list();
			    ModelAndView model = new ModelAndView("PList");
			    model.addObject("productList", pLists);
			    return model;
			 
			 
			//return new ModelAndView("PList");
       }else if("reports".equals(request.getParameter("b3"))) {
			
    	   return new ModelAndView("Reports");
       }else if("usersList".equals(request.getParameter("b4"))) {
			
    	   return new ModelAndView("Customer");
       }else {
			
    	   return new ModelAndView("LoginForm");
       }
		
	
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Users user) {
		System.out.println("in saveuser method" + user);
		entityDAO.saveOrUpdate(user);
		
	    return new ModelAndView("Dashboard");
	}  
	
	@RequestMapping(value = "/dashboardpage", method = RequestMethod.POST)
	public ModelAndView goback(HttpServletRequest request) {
		 
		System.out.println("Im going to dashboard");	
		
	    return new ModelAndView("Dashboard");
	} 
}

