package com.spring.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.spring.pojo.Products;
import com.spring.pojo.User;

public class HibernateUtil {
	static SessionFactory factory;

	public static SessionFactory getSessionFactory(){
		Properties database = new Properties();
		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "root");
		database.setProperty("hibernate.connection.password", "toor");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/spring4db");
		database.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
		database.setProperty("show_sql", "true");
		database.setProperty("hbm2ddl.auto", "update");
		
		Configuration cfg = new Configuration().setProperties(database)
								.addPackage("com.spring.pojo")
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(Products.class);
		StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		
		factory = cfg.buildSessionFactory(ssr.build());
		
		return factory;
	}
}
