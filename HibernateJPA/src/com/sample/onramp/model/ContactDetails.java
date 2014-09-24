package com.sample.onramp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "USER_DETAIL")
@TableGenerator(name="ID_GENERATOR", initialValue=0)
public class ContactDetails {
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="User_ID")
	private String userId;
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	@Column(name = "CITY_NAME")
	private String cityName;
	@Column(name = "ADMIN")
	private Boolean admin;
	
	@OneToOne
	@JoinColumn(name = "SALESFORCE_ID")
	private UserEntity user;

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	
}
