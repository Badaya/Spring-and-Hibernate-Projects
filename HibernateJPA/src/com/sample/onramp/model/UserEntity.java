package com.sample.onramp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "ONRAMP_USER")
@TableGenerator(name="ID_GENERATOR", initialValue=0)
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="SALESFORCE_ID")
	private String salesForceId;
	
	@OneToMany(mappedBy="user" , cascade=CascadeType.ALL)
	List<ContactDetails> addList;

	@Column(name = "ROLE")
	private String role;
	
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	
	@Column(name = "REGION")
	private String region;
	
	
	@Column(name = "MANAGER")
	private Boolean manager;
	
	
	@Column(name = "ADMIN")
	private Boolean admin;
	

	public String getSalesForceId() {
		return salesForceId;
	}

	public void setSalesForceId(String userID) {
		this.salesForceId = userID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Boolean getManager() {
		return manager;
	}

	public void setManager(Boolean manager) {
		this.manager = manager;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String userFullName) {
		this.fullName = userFullName;
	}
	public List<ContactDetails> getAddList() {
		return addList;
	}

	public void setAddList(List<ContactDetails> addList) {
		this.addList = addList;
	}

	
}
