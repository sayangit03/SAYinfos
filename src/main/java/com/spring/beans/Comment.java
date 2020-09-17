package com.spring.beans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(value = "comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	@Id
	private int id;

	private String questionNum;

	private String cmntName;

	private String cmntBody;

	private int likes;

	private int dislikes;

	private Date cmntDate;

	private String domain;

	private String topic;

}
