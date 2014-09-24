package com.spring.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginLogoutController {
	
	@RequestMapping(method=RequestMethod.GET,value="/login.do")
	public String login() {
		
		return "login";
	}	
}
