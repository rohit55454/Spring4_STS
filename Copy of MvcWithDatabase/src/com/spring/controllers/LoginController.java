package com.spring.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/*
	 * @RequestMapping(value="/login", method=RequestMethod.GET) public
	 * ModelAndView loadLoginPage(){ ModelAndView mav = new
	 * ModelAndView("login"); System.out.println("loadLoginPage()...called");
	 * return mav; }
	 */
	/**
	 * when ever we have to handle errors then we can use the following
	 * approach....
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage() {
		System.out.println("loadLoginPage()...called");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("doLogin()...called");
		PrintWriter writer;
		String path = "";
		try {
			String un = req.getParameter("username");
			String pw = req.getParameter("password");
			System.out.println("username : " + un);
			System.out.println("password : " + pw);
			
			if(un.length()==0 || un.trim().length() == 0){
				System.out.println("Plz enter usename & Password");
				writer = res.getWriter();
				writer.println("<b><font color='red'>");
				writer.println("Plz enter usename & Password");
				writer.println("</font></b>");
				return "error";
			}else if(un==pw){
				writer = res.getWriter();
				writer.println("<p><font color='green'>");
				writer.println("<h1>Welcome to Home page....</h1>");
				writer.println("</font></p>");
				return "welcome";
				
			}
			
		} catch (Exception e) {
			System.out.println();
			writer = res.getWriter();
			writer.write("<b><font color='red'>");
			writer.write("OOPS !!!...Something went wrong");
			writer.write("</font></b>");
			return "error";
		}

	}

}
