package com.spring.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Weather {

	String cod;
	String message;
	String cnt;
	List<Forecast> forecastList;
	City city;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public List<Forecast> getForecastList() {
		return forecastList;
	}
	@JsonSetter("list")
	public void setForecastList(List<Forecast> forecastList) {
		this.forecastList = forecastList;
	}
	public City getCity() {
		return city;
	}
	@JsonSetter("city")
	public void setCity(City city) {
		this.city = city;
	}
}
