package com.mfeast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfeast.service.MFeastAppService;
import com.mfeastapp.dao.repository.ContactDetailRepository;
import com.mfeastapp.dao.repository.SurveyRepository;
import com.mfeastapp.dao.repository.UserTableRepository;
import com.mfeastapp.model.ContactDetail;
import com.mfeastapp.model.Survey;
import com.mfeastapp.model.UserTable;


@Service
public class MFeastAppServiceImpl implements MFeastAppService {

	@Autowired 
    private UserTableRepository userTableRepository;
	@Autowired
	private SurveyRepository surveyRepository;
	@Autowired
	private ContactDetailRepository contactDetailRepository;
	
	
	@Transactional
	public void saveUserEntity(UserTable user) {
		userTableRepository.save((UserTable)user);
		
	}


	@Transactional
	public void saveSurvey(Survey survey) {
		surveyRepository.save((Survey)survey);
		
	}


	@Transactional
	@Override
	public UserTable validateUser(String userName, String password) {

		UserTable userTables= (UserTable) userTableRepository.validateUser(userName, password);
		return userTables;
	}
	
	


	@Transactional
	public Survey addUserId(long userId, Survey survey) {
		UserTable user = userTableRepository.getUserByUserId(userId);
		survey.setCreatedUserId(user);
		surveyRepository.save(survey);
		return survey;
	}


	@Transactional
	public ContactDetail getContactByUserId(UserTable userId) {
		ContactDetail contactDetail=contactDetailRepository.getContactByUserId(userId);
		return contactDetail;
	}


	@Transactional
	public void updateUserDetails(long userId, ContactDetail contactDetail) {
		long contactId=contactDetail.getContactId();
		UserTable user=userTableRepository.getUserByUserId(userId);
		contactDetail.setContactId(contactId);
		contactDetail.setUserId(user);
		contactDetailRepository.save(contactDetail);
		
	}


	@Transactional
	public ContactDetail getDisplayPic(UserTable userId) {
		ContactDetail blob=contactDetailRepository.getDisplayPic(userId);
		return blob;
	}


	@Transactional
	public UserTable updatePassword(long userId, String newPassword) {
		UserTable user=userTableRepository.getUserByUserId(userId);
		user.setUserId(userId);
		user.setPassword(newPassword);
		userTableRepository.save(user);
		return user;
	}


	@Transactional
	public List<Survey> getsurveydetails() {
	    List<Survey> surveyList= surveyRepository.getsurveydetails();
		return surveyList;
	}



	

}
