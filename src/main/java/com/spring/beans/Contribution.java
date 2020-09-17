package com.spring.beans;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(value = "contribution")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {

	@Id
	private int id;

	private String userUniqueName;

	private String emailId;

	private String userName;

	private String contriDomain;

	private String contriTopic;

	private String contriQuestion;

	private String contriAnswer;

	private Date contriDate;

	private Date contriUpdateDate;

	private Date approvedDate;

	private boolean contriStatus;

	private List<Comment> cmntList;

}
