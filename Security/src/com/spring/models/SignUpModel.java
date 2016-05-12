package com.spring.models;

import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.spring.pojo.User;
import com.spring.util.HibernateUtil;
import com.spring.util.JDBCUtil;

public class SignUpModel {
	Connection con = null;
	Statement st = null;
	HttpServletResponse resp;
	
	public String doSignup(String username, String password, String email, String phone, String dob, String gender, String vehicle, String country, String zip, String photo, String resume){
		System.out.println("doSignup()...called");
		
		try{
			con = JDBCUtil.getMySqlConnection();
			st = con.createStatement();
			
			st.execute("insert into users values('"+username+"', '"+password+"', '"+email+"', '"+phone+"', '"+dob+"', '"+gender+"', '"+vehicle+"', '"+country+"','"+zip+"', '"+photo+"', '"+resume+"')" );
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String doHibernateSignup(User user){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.save(user);
//			session.update(user);
//			session.delete(user);
//			session.saveOrUpdate(user);
			
			session.getTransaction().commit();
			session.close();
			
//			resp.setContentType("text/html");
//			PrintWriter out = resp.getWriter();
//			out.println("<h1>SignUp Processed successfully</h1>");

			
			return "signUp successfully";
			
		}catch(Exception e){
			e.printStackTrace();
			return "User is already with same name in databse";
		}
		
		
	}
	
}
















