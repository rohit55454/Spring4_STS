package com.spring.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.spring.util.JDBCUtil;

public class LoginModel {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public String do_login_process(String un, String pw){
		try{
			con = JDBCUtil.getMySqlConnection();
			st = con.createStatement();
			rs = st.executeQuery("select count(*) from user where username='"+un+"' and password='"+pw+"'");
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
	
	
}
