package com.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.spring.dao.ProductsDAO;
import com.spring.pojo.Products;
import com.spring.util.HibernateUtil;

public class ProductsDaoImpl implements ProductsDAO{

	@Override
	public List<Products> getAllProducts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Products> allProducts = session.createQuery("from Products").list();
		session.close();
		return allProducts;

	}
}
