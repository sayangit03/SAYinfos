package com.spring.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "question_num")
	private String questionNum;
	
	@Column(name = "cmnt_name")
	private String cmntName;
	
	@Column(name = "cmnt_body")
	@Lob
	private String cmntBody;
	
	@Column(name = "cmnt_likes")
	private int likes;
	
	@Column(name = "cmnt_dislikes")
	private int dislikes;
	
	@Column(name = "cmnt_date")
	private Date cmntDate;
	
	@Transient
	private String domain;
	
	@Transient
	private String topic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(String questionNum) {
		this.questionNum = questionNum;
	}

	public String getCmntName() {
		return cmntName;
	}

	public void setCmntName(String cmntName) {
		this.cmntName = cmntName;
	}

	public String getCmntBody() {
		return cmntBody;
	}

	public void setCmntBody(String cmntBody) {
		this.cmntBody = cmntBody;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public Date getCmntDate() {
		return cmntDate;
	}

	public void setCmntDate(Date cmntDate) {
		this.cmntDate = cmntDate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
