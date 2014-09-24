package com.spring.mvc.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	@Size(min=2, max=30) 	
	private String username;
	
	@Size(min=2, max=15) 
	private String password;
	
	
	@NotEmpty @Email
	private String email;
	
	@NotNull 
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private Date birthDate;
	
	@NotNull
	private String profession;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
