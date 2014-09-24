package com.spring.security.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.security.IChangePassword;


@Controller
public class AccountController  {

	private IChangePassword changePasswordDao;
	
	//@Autowired
	//private UserDetailsManager userDetailsManager;
	
	@RequestMapping("/account/home.do")
	public void accountHome() {		
	}
	
	@RequestMapping(value="/account/changePassword.do",method=RequestMethod.GET)
	public void showChangePasswordPage() {		
	}
	
	@RequestMapping(value="/account/changePassword.do",method=RequestMethod.POST)
	public String submitChangePasswordPage(@RequestParam("password") String newPassword) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = principal.toString();
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		}
		
		changePasswordDao.changePassword(username, newPassword);
		SecurityContextHolder.clearContext();
		
		return "redirect:home.do";
	}

}