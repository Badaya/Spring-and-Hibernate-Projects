package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sample.onramp.model.ContactDetails;
import com.sample.onramp.model.UserEntity;
import com.sample.service.ContactService;
import com.sample.dao.repository.ContactRepository;
import com.sample.dao.repository.UserRepository;
public class ContactServiceImpl implements ContactService {
	
	  @Autowired 
	    private ContactRepository contactRepository;

	 @Transactional
	    public void saveContactDetails(ContactDetails contactServiceImpl) {
		 contactRepository.save((ContactDetails)contactServiceImpl);
	    }

}
