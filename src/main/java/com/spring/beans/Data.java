package com.spring.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Data {
Summary summary;
List<Regional> regional;

public Summary getSummary() {
	return summary;
}

@JsonSetter("summary")
public void setSummary(Summary summary) {
	this.summary = summary;
}

public List<Regional> getRegional() {
	return regional;
}

@JsonSetter("regional")
public void setRegional(List<Regional> regional) {
	this.regional = regional;
}
}
