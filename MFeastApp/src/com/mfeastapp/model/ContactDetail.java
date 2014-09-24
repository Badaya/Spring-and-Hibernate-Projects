package com.mfeastapp.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "CONTACT_DETAIL")
@TableGenerator(name="ID_GENERATOR", initialValue=0)
public class ContactDetail {

	@Id @GeneratedValue
    @Column(name="CONTACT_ID")
	private long contactId;
	@Column(name="MOBILE_NUMBER")
	private long mobileNumber;
    @Column(name="PERMANENT_ADDRESS")
	private String permenantAddress;
    @Column(name="TEMPORARY_ADDRESS")
    private String temporaryAddress;
    @Column(name="DISPLAY_IMAGE")
	private Blob displayPic;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private UserTable userId;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPermenantAddress() {
		return permenantAddress;
	}

	public void setPermenantAddress(String permenantAddress) {
		this.permenantAddress = permenantAddress;
	}

	public String getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}

	public UserTable getUserId() {
		return userId;
	}

	public void setUserId(UserTable userId) {
		this.userId = userId;
	}

	public Blob getDisplayPic() {
		return displayPic;
	}

	public void setDisplayPic(Blob displayPic) {
		this.displayPic = displayPic;
	}
	

}