package com.mfeastapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "USER_ROLE")
public class UserRole {
    
	/**
	 * 
	 */
	

	@Id @GeneratedValue
    @Column(name="SUQUENCE_ID")
	private long sequenceId;
	
//	private UserTable userId;
//	
//	private RoleTable roleId;

	public long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(long sequenceId) {
		this.sequenceId = sequenceId;
	}
//
//	public UserTable getUserId() {
//		return userId;
//	}
//
//	public void setUserId(UserTable userId) {
//		this.userId = userId;
//	}
//
//	public RoleTable getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(RoleTable roleId) {
//		this.roleId = roleId;
//	}

}
