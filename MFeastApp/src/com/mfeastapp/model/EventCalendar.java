package com.mfeastapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "EVENT_CALENDAR")
public class EventCalendar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue
    @Column(name="ID")
	private long id;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "CONTACT_ID")
//	private ContactDetail contactDetail;
//	
    @Column(name="EVENT_NAME")
	private String eventName;
    @Column(name="EVENT_DATE")
    private Date eventDate;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private UserTable userId;

	

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public UserTable getUserId() {
		return userId;
	}

	public void setUserId(UserTable userId) {
		this.userId = userId;
	}

//	public ContactDetail getContactDetail() {
//		return contactDetail;
//	}
//
//	public void setContactDetail(ContactDetail contactDetail) {
//		this.contactDetail = contactDetail;
//	}

}