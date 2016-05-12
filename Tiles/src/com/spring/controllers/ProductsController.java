package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.registry.RegistryDAO;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@RequestMapping(name="/products", method=RequestMethod.GET)
	public ModelAndView loadProducts(){
		ModelAndView mav = new ModelAndView("products");	// name of jsp file...For HQL
//		ProductsModel pm = new ProductsModel();
//		mav.addObject("allProducts", pm.getAllProducts());
		mav.addObject("allProducts", RegistryDAO.getProductsDAO().getAllProducts());
		return mav;
	}
}
