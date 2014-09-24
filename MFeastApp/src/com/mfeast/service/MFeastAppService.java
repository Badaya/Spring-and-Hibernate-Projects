package com.mfeast.service;

import java.util.List;

import com.mfeastapp.model.ContactDetail;
import com.mfeastapp.model.Survey;
import com.mfeastapp.model.UserTable;

public interface MFeastAppService {

	void saveUserEntity(UserTable user);
	void saveSurvey(Survey survey);
	public UserTable validateUser(String userName, String password);
	Survey addUserId(long userId, Survey survey);
	ContactDetail getContactByUserId(UserTable userId);
	void updateUserDetails(long userId,ContactDetail contactDetail);
	ContactDetail getDisplayPic(UserTable userId);
	UserTable updatePassword(long userId, String newPassword);
	List<Survey> getsurveydetails();
}
