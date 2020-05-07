package com.spring.beans;

import com.fasterxml.jackson.annotation.JsonSetter;

public class City {
String name;
Coord coord;
String country;
String timezone;
String sunrise;
String sunset;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Coord getCoord() {
	return coord;
}
@JsonSetter("coord")
public void setCoord(Coord coord) {
	this.coord = coord;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getTimeZone() {
	return timezone;
}
public void setTimeZone(String timezone) {
	this.timezone = timezone;
}
public String getSunrise() {
	return sunrise;
}
public void setSunrise(String sunrise) {
	this.sunrise = sunrise;
}
public String getSunset() {
	return sunset;
}
public void setSunset(String sunset) {
	this.sunset = sunset;
}
}
