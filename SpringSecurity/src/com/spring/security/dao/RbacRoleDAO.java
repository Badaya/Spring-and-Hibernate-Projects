package com.spring.security.dao;

import java.util.List;

import com.spring.security.data.RbacRole;

public interface RbacRoleDAO {

	public List<RbacRole> fetchAllRoleByUserId(Long userId);
}
