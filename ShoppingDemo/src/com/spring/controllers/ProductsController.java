package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.models.ProductsModel;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@RequestMapping(name="/products", method=RequestMethod.GET)
	public ModelAndView loadProducts(){
		System.out.println("loadProducts()... called");
//		ModelAndView mav = new ModelAndView("products");	// name of jsp file...For HQL
		ModelAndView mav = new ModelAndView("products2");	// for SQL
		ProductsModel pm = new ProductsModel();
		mav.addObject("allProducts", pm.getAllProducts());
		System.out.println(pm.getAllProducts().size());
		System.out.println(mav);
		return mav;
	}
}
