package com.spring.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_contribution")
public class Contribution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_unique_name")
	private String userUniqueName;
	
	@Column(name = "user_email")
	private String emailId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "contri_domain")
	private String contriDomain;
	
	@Column(name = "contri_topic")
	private String contriTopic;
	
	@Column(name = "contri_question")
	private String contriQuestion;
	
	@Column(name = "contri_answer")
	@Lob
	private String contriAnswer;
	
	@Column(name = "contri_date")
	private Date contriDate;
	
	@Column(name = "contri_update_date")
	private Date contriUpdateDate;
	
	@Column(name = "approved_date")
	private Date approvedDate;
	
	@Column(name = "contri_status")
	private boolean contriStatus;

	public Contribution() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserUniqueName() {
		return userUniqueName;
	}

	public void setUserUniqueName(String userUniqueName) {
		this.userUniqueName = userUniqueName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContriDomain() {
		return contriDomain;
	}

	public void setContriDomain(String contriDomain) {
		this.contriDomain = contriDomain;
	}

	public String getContriTopic() {
		return contriTopic;
	}

	public void setContriTopic(String contriTopic) {
		this.contriTopic = contriTopic;
	}

	public String getContriQuestion() {
		return contriQuestion;
	}

	public void setContriQuestion(String contriQuestion) {
		this.contriQuestion = contriQuestion;
	}

	public String getContriAnswer() {
		return contriAnswer;
	}

	public void setContriAnswer(String contriAnswer) {
		this.contriAnswer = contriAnswer;
	}

	public Date getContriDate() {
		return contriDate;
	}

	public void setContriDate(Date contriDate) {
		this.contriDate = contriDate;
	}

	public Date getContriUpdateDate() {
		return contriUpdateDate;
	}

	public void setContriUpdateDate(Date contriUpdateDate) {
		this.contriUpdateDate = contriUpdateDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public boolean isContriStatus() {
		return contriStatus;
	}

	public void setContriStatus(boolean contriStatus) {
		this.contriStatus = contriStatus;
	}
	
}
