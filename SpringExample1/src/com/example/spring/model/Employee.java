package com.example.spring.model;

public class Employee {

	private String name;
	private String company;
	
	public Employee() {
		System.out.println("Employee constructor executed");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
