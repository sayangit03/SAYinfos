package com.spring.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class IndiaCovid {
	String state;
	String statecode;
	String active;
	String deaths;
	String revives;
	List<District> districtData;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public List<District> getDistrictData() {
		return districtData;
	}
	@JsonSetter("districtData")
	public void setDistrictData(List<District> districtData) {
		this.districtData = districtData;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getRevives() {
		return revives;
	}
	public void setRevives(String revives) {
		this.revives = revives;
	}
}
