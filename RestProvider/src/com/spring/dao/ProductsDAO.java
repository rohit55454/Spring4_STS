package com.spring.dao;

import java.util.List;

import com.spring.pojo.Products;

public interface ProductsDAO {
	public List<Products> getAllProducts();
	public boolean deleteProductById(String id);
	public Products getProductById(Integer productId);
}
