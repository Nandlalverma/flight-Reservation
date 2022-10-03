package com.flight_Reservation_app_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_Reservation_app_5.entity.User;
import com.flight_Reservation_app_5.repository.UserRepository;

@Controller
public class UserController {

	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		
		
		return "login";
	}
	
	
	@RequestMapping("/showReg")
	public String showReg() {
		
		return "showReg";
	}
	
	@RequestMapping("/saveReg")
	public String SaveReg(@ModelAttribute("user") User user)
	{
		userRepository.save(user);
		
		return "login";
	}
	
	@RequestMapping("/verifylogin")
	public String verifylogin(@RequestParam("emailId") String emailId,
			@RequestParam("password") String password,ModelMap modelMap) {
		User user = userRepository.findByEmail(emailId);
		//System.out.println(user);
		//System.out.println(emailId);
		//System.out.println(password);
		if(user.getEmail().equals(emailId) && user.getPassword().equals(password))
		{
			return "findFlights";
		}else {
			modelMap.addAttribute("error", "invalid id or password");
			return "login";
			
		}
		
		
	}



	
}
