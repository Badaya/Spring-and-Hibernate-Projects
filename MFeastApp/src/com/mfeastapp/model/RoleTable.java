package com.mfeastapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class RoleTable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
    @Column(name="ROLE_ID")
	private long roleId;
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "userRole")   
    private List<UserTable> userList; 

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserTable> getUserList() {
		return userList;
	}

	public void setUserList(List<UserTable> userList) {
		this.userList = userList;
	}

}
