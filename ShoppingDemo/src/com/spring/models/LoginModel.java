package com.spring.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.spring.pojo.User;
import com.spring.util.HibernateUtil;
import com.spring.util.JDBCUtil;

public class LoginModel {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public String do_login_process(String un, String pw){
		try{
			con = JDBCUtil.getMySqlConnection();
			st = con.createStatement();
			rs = st.executeQuery("select count(*) from users where username='"+un+"' and password='"+pw+"'");
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			rs.close();
			if(count == 1)	return "login success";
			else			return "username / password does not match...";
			
			
		}catch(Exception e){
			System.out.println("Something went wrong....");
			e.printStackTrace();
			return "Something went wrong ...Plz try later....";
		}
		
	}

	public String doHibernateLogin(String un, String pw) {
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			System.out.println("tx begins");
			List<User> user = session.createQuery("from User where username='"+un+"' and password='" +pw+"'").list();
			System.out.println(user);
			session.close();
			System.out.println("session closed");
			
			if(user.size() == 1) return "LoginSuccess";
			else				 return "Plz... try Again...";
			
		}catch(Exception e){
			return " Some Exception occured Plz...try Again !!!!!!!";
		}
		
	}
	
	
}
