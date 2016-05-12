package com.spring.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.models.UserModel;

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
	public String doLogin(HttpServletRequest req, Model md, HttpSession session) throws IOException {
		System.out.println("doLogin()...called");
		
		try {
			String un = req.getParameter("username");
			String pw = req.getParameter("password");
			System.out.println("username : " + un);
			System.out.println("password : " + pw);
			
			UserModel um = new UserModel();
			String msg = um.do_login_process(un, pw);
			
			if(msg.equals("login success")){
				session.setAttribute("un", un);
				return "redirect:/welcome";
			}
			else
				md.addAttribute("error_msg", msg);
			
			return "login";
		} catch (Exception e) {
			System.out.println();
			
			return "error";
		}

	}

}
