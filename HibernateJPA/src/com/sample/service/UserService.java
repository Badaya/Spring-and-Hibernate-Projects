package com.sample.service;

import java.util.List;

import com.sample.onramp.model.UserEntity;

public interface UserService {
	
	UserEntity getUserDetailById(String id);
	
	List<UserEntity> getAllUser();
	
	Long countAll();
	
	void saveUserEntity(UserEntity UserEntity);
	
    List<UserEntity> getAllUser(String userId);
    
    List<UserEntity> getAllUserByRegion(String region, String userId);
	
//	UserEntity checkUserAccess(String userId, Long proposalId);
}
