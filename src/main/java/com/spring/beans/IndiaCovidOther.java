package com.spring.beans;

import com.fasterxml.jackson.annotation.JsonSetter;

public class IndiaCovidOther {
String success;
Data data;

public String getSuccess() {
	return success;
}
public void setSuccess(String success) {
	this.success = success;
}
public Data getData() {
	return data;
}

@JsonSetter("data")
public void setData(Data data) {
	this.data = data;
}

}
