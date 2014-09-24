package com.rest.spring.jersey.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ClientData")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ClientData implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "market vertical")
	private String marketVertical;

	@XmlElement(name = "address")
	private String address;

	@XmlElement(name = "contact1")
	private String contact1;

	@XmlElement(name = "contact2")
	private String contact2;

	public String getMarketVertical() {
		return marketVertical;
	}

	public void setMarketVertical(String marketVertical) {
		this.marketVertical = marketVertical;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

}
