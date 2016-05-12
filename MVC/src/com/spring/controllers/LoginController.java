package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loadLoginPage(){
		ModelAndView mav = new ModelAndView("login");
		System.out.println("loadLoginPage()...called");
		return mav;
	}

	/**
	 * when ever we have to handle errors then we can use the following approach....
	 */
	
/*	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loadLoginPage(){
		System.out.println("loadLoginPage()...called");
		return "login";
	}
*/	
}
