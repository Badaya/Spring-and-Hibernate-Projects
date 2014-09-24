package com.mfeastapp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TABLE")
public class UserTable  implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
    @Column(name="USER_ID")
	private long userId;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="SALT")
	private String salt;
	@Column(name="ACTIVE")
	private boolean active;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDDLE_NAME")
	private String middleName;
	@Column(name="LAST_NAME")
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)  
    @JoinTable(name="USER_ROLE",  
    joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")},  
    inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ROLE_ID")}) 
	private RoleTable userRole;  
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RoleTable getUserRole() {
		return userRole;
	}

	public void setRoleTable(RoleTable roleTable) {
		this.userRole = roleTable;
	}

}
