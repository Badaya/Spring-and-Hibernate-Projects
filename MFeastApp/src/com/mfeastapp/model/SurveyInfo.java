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



@Entity
@Table(name = "SURVEY_INFO")
public class SurveyInfo implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
    @Column(name="SURVEY_INFO_ID")
	private long surveyInfoId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="SURVEY_ID")
	private Survey surveyId;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
	private UserTable userId;
	@Column(name="SURVEY_OPTION")
	private String surveyOption;
	@Column(name="FEEDBACK")
	private String feedback;
	@Column(name="CREATED_DATE")
	private Date createdDate;

	public long getSurveyInfoId() {
		return surveyInfoId;
	}

	public void setSurveyInfoId(long surveyInfoId) {
		this.surveyInfoId = surveyInfoId;
	}

	public Survey getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
	}

	public UserTable getUserId() {
		return userId;
	}

	public void setUserId(UserTable userId) {
		this.userId = userId;
	}

	public String getSurveyOption() {
		return surveyOption;
	}

	public void setSurveyOption(String surveyOption) {
		this.surveyOption = surveyOption;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
