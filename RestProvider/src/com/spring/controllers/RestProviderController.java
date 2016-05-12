package com.spring.controllers;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.registry.RegistryDAO;
import com.spring.pojo.Products;

@RestController
public class RestProviderController {

	@RequestMapping(name="/jsonGetProductById/{productId}", method=RequestMethod.GET)
	public String jsonGetProductById(@PathVariable("productId") Integer productId){
		
		Products product = RegistryDAO.getProductsDAO().getProductById(productId);
		JSONObject json = new JSONObject(product);
		
		return json.toString();
	}
	
}
