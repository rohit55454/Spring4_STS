package com.spring.dao.registry;

import com.spring.dao.impl.ProductsDaoImpl;

public class RegistryDAO {
	public static com.spring.dao.ProductsDAO productsDAO;
	
	static{
		productsDAO = new ProductsDaoImpl();
	}

	public static com.spring.dao.ProductsDAO getProductsDAO() {
		return productsDAO;
	}

	public static void setProductsDAO(com.spring.dao.ProductsDAO productsDAO) {
		RegistryDAO.productsDAO = productsDAO;
	}
	
	
}
