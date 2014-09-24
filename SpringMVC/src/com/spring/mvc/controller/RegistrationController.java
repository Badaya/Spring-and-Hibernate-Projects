package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.model.User;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		User userForm = new User();
		model.put("userForm", userForm);

		populateProfessionList(model);

		return "Registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") @Valid User user, BindingResult result, 
			Map<String, Object> model) {

		populateProfessionList(model);

		if(result.hasErrors()) {
			return "Registration";
		}
		// implement your own registration logic here...

		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("birth date: " + user.getBirthDate());
		System.out.println("profession: " + user.getProfession());

		return "RegistrationSuccess";
	}
	
	private void populateProfessionList(Map<String, Object> model) {
		List<String> professionList = new ArrayList<>();
		
		professionList.add("Developer");
		professionList.add("Designer");
		professionList.add("IT Manager");
		
		model.put("professionList", professionList);
	}
}