package com.simplilearn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.dao.EntityDAO;
import com.simplilearn.model.Product;;


@Controller
//@RequestMapping("product")
public class ProductController {
	
	
	@Autowired
	private EntityDAO entityDAO;
	
	@RequestMapping("/handleRequest")
	public ModelAndView PhandleRequest() throws Exception {
	    List<Product> pLists = entityDAO.list();
	    ModelAndView model = new ModelAndView("PList");
	    model.addObject("productList", pLists);
	    System.out.println("Im in product /");
	    return model;
	}
	 
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newProduct() {
	    ModelAndView model = new ModelAndView("PForm");
	    model.addObject("product", new Product());
	    System.out.println("Im in product new method");
	    return model;      
	}
	
		 
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editProduct(HttpServletRequest request) {
	    int pID = Integer.parseInt(request.getParameter("productID"));
	    Product p = entityDAO.getPID(pID);
	    ModelAndView model = new ModelAndView("PForm");
	    model.addObject("product", p);
	    return model;      
	}
	 
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest request) {
	    int pID = Integer.parseInt(request.getParameter("productID"));
	    entityDAO.deletePID(pID);
	    return new ModelAndView("redirect:/handleRequest");     
	}
	 
	@RequestMapping(value = "/saving", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute Product product) {
	    entityDAO.PsaveOrUpdate(product);
	    return new ModelAndView("redirect:/handleRequest");
	}  
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView categorize(HttpServletRequest request) {
	    ModelAndView model = new ModelAndView("Pcategory");
	   // model.addObject("product", new Product());
	    System.out.println("Im in product category method");
	    return model;      
	}
	
	@RequestMapping(value = "/cat-gender", method = RequestMethod.GET)
	public ModelAndView gender(HttpServletRequest request) {
		String choice = request.getParameter("gender");
		
		System.out.println(choice);
		
        List<Product> p = entityDAO.catGender(choice);
	
	    ModelAndView model = new ModelAndView("Pcategory");
	    model.addObject("product", p);
	    
	    System.out.println("Im in cat gender method");
	    return model;      
	}
	
	@RequestMapping(value = "/dashboardpg", method = RequestMethod.POST)
	public ModelAndView dashb(HttpServletRequest request) {
	    ModelAndView model = new ModelAndView("Dashboard");	  
	    return model;      
	}
	
	

}
