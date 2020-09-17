package com.spring.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(value = "flashuser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlashUser {

	private int id;
	private String userName;
	private String emailId;
	private String userUniqueName;
}
