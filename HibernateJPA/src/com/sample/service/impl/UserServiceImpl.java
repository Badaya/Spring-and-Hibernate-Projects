package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.repository.UserRepository;
import com.sample.onramp.model.UserEntity;
import com.sample.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired 
    private UserRepository userRepository;

    @Override
    public UserEntity getUserDetailById(final String userId) {
        final UserEntity userEntityImpl = (UserEntity) userRepository.getUserDetailById(userId);
        return userEntityImpl;
    }

    @Override
    public List<UserEntity> getAllUser() {
        List<UserEntity> userEntityList = userRepository.getAllUser();
        return userEntityList;
    }

    @Override
    public Long countAll() {
        return userRepository.count();
    }

    @Transactional
    public void saveUserEntity(UserEntity userEntityImpl) {
         userRepository.save((UserEntity)userEntityImpl);
    }

    @Override
    public List<UserEntity> getAllUserByRegion(String region, String userId) {
         return userRepository.getAllUsersByRegion(region, userId);
    }

    @Override
    public List<UserEntity> getAllUser(String userId) {
        return userRepository.getAllUser(userId);
    }
    
//	@Override
//	public UserEntity checkUserAccess(String userId, Long proposalId) {
//		 return userRepository.checkProposalAccess(userId, proposalId);
//	}

}
