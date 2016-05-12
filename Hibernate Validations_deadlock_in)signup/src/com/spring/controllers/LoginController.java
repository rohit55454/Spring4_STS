package com.spring.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.models.LoginModel;
import com.spring.pojo.User;

@Controller
public class LoginController {

	/**
	 * when ever we have to handle errors then we can use the following
	 * approach....
	 */

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * String loadLoginPage() { System.out.println("loadLoginPage()...called");
	 * return "login"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		System.out.println("loadLoginPage()... called");
		ModelAndView mav = new ModelAndView("login");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest req, Model md, HttpSession session, @Valid User user, BindingResult br)
			throws IOException {
		System.out.println("doLogin()...called");

		try {
			System.out.println(br.getErrorCount());
			System.out.println(br.getAllErrors().size());

			String un = req.getParameter("username");
			String pw = req.getParameter("password");
			System.out.println("username : " + un);
			System.out.println("password : " + pw);

			if (br.getAllErrors().size() > 0) {
				System.out.println("server side validation tkes place");
			} else {
				LoginModel lm = new LoginModel();
				
			//	Hibernate
				String msg = lm.doHibernateLogin(un, pw);
				if (msg.equals("login success")) {
					session.setAttribute("un", un);
					return "redirect:/welcome";
				} else
					md.addAttribute("error_msg", msg);
				
			//	JDBC	
/*				String msg = um.do_login_process(un, pw);

				if (msg.equals("login success")) {
					session.setAttribute("un", un);
					return "redirect:/welcome";
				} else
					md.addAttribute("error_msg", msg);
*/			}
			return "login";
		} catch (Exception e) {
			System.out.println();

			return "error";
		}

	}

	// Hit counter Login Page
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * ModelAndView loadLoginPage(HttpServletResponse
	 * response, @CookieValue(value="hits", defaultValue="0")Long hits) {
	 * System.out.println("loadLoginPage()... called"); ModelAndView mav = new
	 * ModelAndView("login");
	 * 
	 * hits++; Cookie ck = new Cookie("hits", hits.toString()); //
	 * ck.setMaxAge(60); response.addCookie(ck);
	 * 
	 * return mav; }
	 */
}
