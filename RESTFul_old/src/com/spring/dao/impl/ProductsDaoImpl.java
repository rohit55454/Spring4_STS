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

	@Override
	public boolean deleteProductById(String id) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<Products> product = session.createQuery("From Products where id='"+id+"'").list();
			
			if(product != null && product.get(0) != null){
				session.beginTransaction();
				session.delete(product.get(0));
				session.getTransaction().commit();
				session.close();
			}
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Products getProductById(String id) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<Products> product = session.createQuery("From Products where id='"+id+"'").list();
			return product.get(0);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
