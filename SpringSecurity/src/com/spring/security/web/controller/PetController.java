package com.spring.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetController {

	//listPets.do?species=dog
	@RequestMapping(method=RequestMethod.GET,value="/listPets.do") 
	public String listPet(@RequestParam("species") String species){
		
		if(species != null) {
			if("dog".equals(species)) {
				return "pets/dogbreed";
			}
			else if("cat".equals(species)) {
				return "pets/catbreed";
			}
		}
		
		return null;
	}
}
