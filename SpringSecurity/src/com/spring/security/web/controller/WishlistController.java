/**
 * 
 */
package com.spring.security.web.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.security.data.Item;

@Controller
@RequestMapping("/wishlist/home.do")
public class WishlistController {
	
	@RequestMapping(method=RequestMethod.GET)
	public void show() {
		
	}
	
	@ModelAttribute("wishlistItems")
	public Collection<Item> getWishlistItems() {
		return new ArrayList<Item>();
	}
}
