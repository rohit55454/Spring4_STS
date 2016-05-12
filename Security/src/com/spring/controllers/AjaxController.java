package com.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dao.registry.RegistryDAO;

@Controller
public class AjaxController {
	
	@ResponseBody
	@RequestMapping(value="/deleteProduct", method=RequestMethod.POST)
	public String deleteProduct(HttpServletRequest req){
		String productId = req.getParameter("productId");
		
		boolean flag = RegistryDAO.getProductsDAO().deleteProductById(productId);
		
		if(flag){
			return "Product deleted Successfully...";
		}
		else{
			return "Plz try Again..";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest req){
		String productId = req.getParameter("productId");
		
		boolean flag = RegistryDAO.getProductsDAO().deleteProductById(productId);
		
		if(flag){
			return "Product Added Successfully...";
		}
		else{
			return "Plz try Again..";
		}
		
	}
}
