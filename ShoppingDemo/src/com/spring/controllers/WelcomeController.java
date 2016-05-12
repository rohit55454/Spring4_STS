package com.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public ModelAndView load_welcome(HttpSession session){
		ModelAndView mav = new ModelAndView("welcome");
		String un = session.getAttribute("un").toString();
		
		mav.addObject("un", un);
		
		return mav;
	}

}





