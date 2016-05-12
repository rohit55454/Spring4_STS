/**
 * remove commons-file-upload from build path and add commons-file-upload to dependency. 
 */

package com.spring.controllers;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.models.SignUpModel;
import com.spring.pojo.User;

@Controller
public class SignUpController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup_do() {
		ModelAndView mav = new ModelAndView("signup");

		return mav;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup_process(HttpServletRequest request, HttpServletResponse res) {
		System.out.println("signup_process()...called");
		ModelAndView mav = new ModelAndView("signup");
		String msg = "";

		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String username = data.get(0).getString();
				String password = data.get(1).getString();
				String repassword = data.get(2).getString();
				String email = data.get(3).getString();
				String phone = data.get(4).getString();
				String dob = data.get(5).getString();
				String gender = data.get(6).getString();
				String vehicle = data.get(7).getString();
				String country = data.get(8).getString();
				String zip = data.get(9).getString();
				String photo = new File(data.get(10).getName()).getName();
				String resume = new File(data.get(11).getName()).getName();

				System.out.println("username :" + username);
				System.out.println("password :" + password);
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setPhone(phone);
				user.setDob(dob);
				user.setGender(gender);
				user.setVehicle(vehicle);
				user.setCountry(country);
				user.setZip(zip);
				user.setPhoto(photo);
				user.setResume(resume);
				

				if (password.equals(repassword)) {
					System.out.println("checking pw == repwd");
					SignUpModel sm = new SignUpModel();
//					sm.doSignup(username, password, email, phone, dob, gender, vehicle, country, zip, photo, resume);
					msg = sm.doHibernateSignup(user);
					
					String path1 = request.getSession().getServletContext().getRealPath("/")
							+ "//WEB-INF//media//images//";
					data.get(10).write(new File(path1 + File.separator + photo));
					System.out.println("photo is going to upload.....");
					
					String path2 = request.getSession().getServletContext().getRealPath("/")
							+ "//WEB-INF//media//images//";
					data.get(11).write(new File(path2 + File.separator + resume));
					System.out.println("resume is going to upload.....");
					
					res.setContentType("text/html");
					PrintWriter out = res.getWriter();
					out.println("<h2>SignUp Successful</h2>");
					System.out.println("SignUp Successful");
				}else {
					msg = "Password does not match...try again";
				}

			} catch (Exception e) {
				System.out.println(e);
				msg = "Plz... try Again";
			}
		}

		mav.addObject("msg", msg);
		return mav;
	}

	// Handling Dynamic URL
	// Access as http://localhost:1112/SignUp/dynamic/<random String or integer>
	@RequestMapping(value = "/dynamic/{message}", method = RequestMethod.GET)
	public ModelAndView dynamicDemo(@PathVariable("message") String message) {
		System.out.println("dynamicDemo()...called");
		ModelAndView mav = new ModelAndView("signup");

		System.out.println(message);

		return mav;
	}

}
