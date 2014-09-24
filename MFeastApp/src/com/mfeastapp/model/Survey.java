package com.mfeastapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sample.FeastType;

@Entity
@Table(name = "SURVEY")
public class Survey implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
    @Column(name="SURVEY_ID")
	private long surveyId;
	@Column(name="SURVEY_NAME")
	private String surveyName;
	@Column(name="DESCRIPTION")
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE")
	private FeastType type;
	@Column(name="VEG_OPTION")
	private String vegOption;
	@Column(name="JAIN_OPTION")
	private String jainOption;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
	private UserTable createdUserId;
	@Column(name="CREATED_DATE")
	private Date createdDate;
	private boolean openSurveyFlag;

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FeastType getType() {
		return type;
	}

	public void setType(FeastType feastpoll) {
		this.type = feastpoll;
	}

	public String getVegOption() {
		return vegOption;
	}

	public void setVegOption(String vegOption) {
		this.vegOption = vegOption;
	}

	public String getJainOption() {
		return jainOption;
	}

	public void setJainOption(String jainOption) {
		this.jainOption = jainOption;
	}

	public UserTable getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(UserTable createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isOpenSurveyFlag() {
		return openSurveyFlag;
	}

	public void setOpenSurveyFlag(boolean openSurveyFlag) {
		this.openSurveyFlag = openSurveyFlag;
	}

}
