package com.spring.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Forecast {
String dt;
ForeMain mainfore;
List<ForeWeather> foreWeatherList;
Cloud cloud;
Wind wind;
Sys sys;
String dt_txt;
public String getDt() {
	return dt;
}
public void setDt(String dt) {
	this.dt = dt;
}
public ForeMain getMainfore() {
	return mainfore;
}
@JsonSetter("main")
public void setMainfore(ForeMain mainfore) {
	this.mainfore = mainfore;
}
public List<ForeWeather> getForeWeatherList() {
	return foreWeatherList;
}
@JsonSetter("weather")
public void setForeWeatherList(List<ForeWeather> foreWeatherList) {
	this.foreWeatherList = foreWeatherList;
}
public Cloud getCloud() {
	return cloud;
}
@JsonSetter("clouds")
public void setCloud(Cloud cloud) {
	this.cloud = cloud;
}
public Wind getWind() {
	return wind;
}
@JsonSetter("wind")
public void setWind(Wind wind) {
	this.wind = wind;
}
public Sys getSys() {
	return sys;
}
@JsonSetter("sys")
public void setSys(Sys sys) {
	this.sys = sys;
}
public String getDtTxt() {
	return dt_txt;
}
@JsonSetter("dt_txt")
public void setDtTxt(String dt_txt) {
	this.dt_txt = dt_txt;
}
}
