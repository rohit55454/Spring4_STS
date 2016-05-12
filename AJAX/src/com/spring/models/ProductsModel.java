package com.spring.models;

import java.util.List;

import com.spring.dao.impl.ProductsDaoImpl;
import com.spring.pojo.Products;

public class ProductsModel {
	
	public List<Products> getAllProducts() {
		
		return new ProductsDaoImpl().getAllProducts();
	}

	

}
