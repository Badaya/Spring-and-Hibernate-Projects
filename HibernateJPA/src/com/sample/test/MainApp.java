package com.sample.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.onramp.model.ContactDetails;
import com.sample.onramp.model.UserEntity;
import com.sample.service.UserService;

public class MainApp {

	public static void main(String[] args) {
		try{
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"onramp-dao-infrastructure.xml", 
					"onramp-daos.xml");
			ContactDetails contact=new ContactDetails();
			contact.setCityName("Gainesville");
			contact.setCountryName("USA");
			contact.setAdmin(true);
			contact.setUserId("12345");
			
			UserEntity user = new UserEntity();
			user.setAdmin(true);
			user.setFirstName("Abhinav");
			user.setLastName("Pandey");
			user.setFullName("Abhinav Pandey");
			user.setSalesForceId("SAL0001234454");
			user.setManager(true);
			user.setRegion("LA");
			user.setRole("LA-Manager");
		    List<ContactDetails> addList = new ArrayList<ContactDetails>();
			addList.add(contact);

			user.setAddList(addList);
            user.setAddList(addList);
			UserService service = context.getBean(UserService.class);
			service.saveUserEntity(user);
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
