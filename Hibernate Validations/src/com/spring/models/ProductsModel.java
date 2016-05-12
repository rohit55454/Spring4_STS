package com.spring.models;

import java.util.List;

import org.hibernate.Session;

import com.spring.pojo.Products;
import com.spring.util.HibernateUtil;

public class ProductsModel {
	public List<Products> getAllProducts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Products> allProducts = session.createQuery("from Products").list();
		session.close();
		return allProducts;
	}
}
