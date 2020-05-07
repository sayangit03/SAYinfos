package com.spring.beans;

public class CountryCovid {
	
	 private String countryName;
	 private String cases;
	 private String deaths;
	 private String region;
	 private String totalRecovered;
	 private String newDeaths;
	 private String newCases;
	 private String seriousCritical;
	 private String activeCases;
	 private String totalCasesPer1mPopulation;
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCases() {
		return cases;
	}
	public void setCases(String cases) {
		this.cases = cases;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTotalRecovered() {
		return totalRecovered;
	}
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	public String getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}
	public String getNewCases() {
		return newCases;
	}
	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}
	public String getSeriousCritical() {
		return seriousCritical;
	}
	public void setSeriousCritical(String seriousCritical) {
		this.seriousCritical = seriousCritical;
	}
	public String getActiveCases() {
		return activeCases;
	}
	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
	}
	public String getTotalCasesPer1mPopulation() {
		return totalCasesPer1mPopulation;
	}
	public void setTotalCasesPer1mPopulation(String totalCasesPer1mPopulation) {
		this.totalCasesPer1mPopulation = totalCasesPer1mPopulation;
	}

}
