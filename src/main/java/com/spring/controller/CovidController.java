package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.spring.beans.CountryCovid;
import com.spring.beans.Covid;
import com.spring.beans.District;
import com.spring.beans.IndiaCovid;
import com.spring.beans.IndiaCovidOther;
import com.spring.beans.Regional;
import com.spring.resource.CovidResource;

@Controller
public class CovidController {


	@Autowired 
	CovidResource cResource;


	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/worldCovid")
	public String getCovid19Resource(ModelMap mpdelMap) {
		Covid covid = new Covid();
		covid = cResource.getCovid19ResourceService();
		mpdelMap.addAttribute("covid", covid);
		return "covid19_result";
	}

	@RequestMapping("/covid19Display")
	public String covidDisp() {
		System.out.println("COVID 19 Display.");

		return "covid19";
	}

	@RequestMapping("/countryCovid")
	public String getCountryWiseCovidDisp(ModelMap modelMap) {
		List<List<CountryCovid>> listCCList = new ArrayList<>();
		listCCList = cResource.getCountryCovid19ResourceService();
		modelMap.addAttribute("listccList", listCCList);

		return "covid19Country_result";
	}

	@GetMapping("/indiaCovid")
	public String getIndiaCovidResult(ModelMap modelMap) {
		List<IndiaCovid> indCovidList = cResource.getIndiaCovid();
		for(IndiaCovid ind : indCovidList) {
			for(District dis : ind.getDistrictData()) {
				dis.setDistrictId(dis.getDistrict().replaceAll("\\s", ""));
			}
		}

		IndiaCovidOther ico = cResource.getIndiaCovidOther();

		for(IndiaCovid ind : indCovidList) {
			for(Regional region : ico.getData().getRegional()) {
				if(ind.getState().equals(region.getLoc())) {
					ind.setActive(region.getTotalConfirmed());
					ind.setDeaths(region.getDeaths());
					ind.setRevives(region.getDischarged());
				}
				if(ind.getState().equals("Telangana") && region.getLoc().equals("Telengana")) {
					ind.setActive(region.getTotalConfirmed());
					ind.setDeaths(region.getDeaths());
					ind.setRevives(region.getDischarged());
				}
			}
		}
		if(ico.getData().getSummary().getTotal()!=null) {
			modelMap.addAttribute("indActive", ico.getData().getSummary().getTotal());
			modelMap.addAttribute("indDeath", ico.getData().getSummary().getDeaths());
			modelMap.addAttribute("indRevive", ico.getData().getSummary().getDischarged());
		}
		else {
			modelMap.addAttribute("indActive", ico.getData().getUnofficialSummary().get(0).getTotal());
			modelMap.addAttribute("indDeath", ico.getData().getUnofficialSummary().get(0).getDeaths());
			modelMap.addAttribute("indRevive", ico.getData().getUnofficialSummary().get(0).getRecovered());
		}


		modelMap.addAttribute("indCovidList", indCovidList);
		return "covid19_india";
	}

	/*
	 * @RequestMapping("/worldCovid") public List<Object> getWorldCovidUpdate() {
	 * CovidResource cResource = new CovidResource();
	 * 
	 * 
	 * //return "covid19_result.jsp"; return cResource.getCovid19Resource("all"); }
	 */
}
