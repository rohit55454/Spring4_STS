package com.spring.models;

import java.sql.Connection;
import java.sql.Statement;

import com.spring.util.JDBCUtil;

public class SignUpModel {
	Connection con = null;
	Statement st = null;
	
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
	
	
}




