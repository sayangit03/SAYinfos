package com.spring.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.spring.beans.CountryCovid;
import com.spring.beans.Covid;
import com.spring.beans.IndiaCovid;
import com.spring.beans.IndiaCovidOther;

@Service
public class CovidResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	Environment env;
	
	Logger logger = LoggerFactory.getLogger(CovidResource.class);
	
	public Covid getCovid19ResourceService() {
		logger.info("START SERVICE:: For world covid 19 results.");
		Covid covidFinal;
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("x-rapidapi-host", env.getProperty("covid.world.host"));
			httpHeaders.add("x-rapidapi-key", env.getProperty("covid.world.key"));
			String url = null;
			String name = "all";
			if(name.equals("all")) {
				url = env.getProperty("covid.world.url");
			}
			else {
				logger.info("SERVICE:: Future development for search by country name: "+name);
			}
			HttpEntity<String> req = new HttpEntity<String>(httpHeaders);
			Covid[] covids = restTemplate.exchange(url, HttpMethod.GET, req, Covid[].class).getBody();

			Covid covid = new Covid();
			covid = Arrays.asList(covids).get(0);
			covidFinal = covid;
		}
		catch (Exception e) {
			// TODO: handle exception
			covidFinal = null;
		}
		logger.info("END SERVICE:: For world covid 19 results.");
		return covidFinal;
	}
	
	public List<List<CountryCovid>> getCountryCovid19ResourceService() {
		logger.info("START SERVICE:: For country covid 19 results.");
		List<List<CountryCovid>> listCCList = new ArrayList<>();
		List<CountryCovid> countryCovidList = new ArrayList<>();
		try {
			HttpResponse<String> response = Unirest.get(env.getProperty("covid.country.url"))
					.header("x-rapidapi-host", env.getProperty("covid.country.host"))
					.header("x-rapidapi-key", env.getProperty("covid.country.key"))
					.asString();
			//System.out.println(response.getBody());
			StringTokenizer st = new StringTokenizer(response.getBody(), "{");
			List<String> stList = new ArrayList<>();
			while(st.hasMoreTokens()){
				stList.add(st.nextToken());
			}
			stList.remove(0);
			stList.remove(stList.size()-1);
			//System.out.println(stList.get(0).substring(0, stList.get(0).length()-2));
			Map<String, String> map = null;
			List<Map<String, String>> mapList = new ArrayList<>();
			ObjectMapper om = new ObjectMapper();
			for(String s : stList) {
				String s1 = s.substring(0, s.length()-2);
				map = om.readValue("{"+s1+"}", Map.class);
				mapList.add(map);
			}

			for(Map<String, String> m : mapList) {
				List<String> covidList = new ArrayList<>();
				CountryCovid cCovid = new CountryCovid();
				for(String finalVal : m.values()) {
					if(finalVal!=null && !finalVal.isEmpty()) {
						covidList.add(finalVal);
					}
					else {
						covidList.add("Not Available");
					}
				}
				if(covidList.size()>=10) {
					cCovid.setCountryName(covidList.get(0));
					cCovid.setCases(covidList.get(1));
					cCovid.setDeaths(covidList.get(2));
					cCovid.setRegion(covidList.get(3));
					cCovid.setTotalRecovered(covidList.get(4));
					cCovid.setNewDeaths(covidList.get(5));
					cCovid.setNewCases(covidList.get(6));
					cCovid.setSeriousCritical(covidList.get(7));
					cCovid.setActiveCases(covidList.get(8));
					cCovid.setTotalCasesPer1mPopulation(covidList.get(9));
				}
				countryCovidList.add(cCovid);
			}
			logger.info("SERVICE:: Total countries: "+countryCovidList.size());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<CountryCovid> l = null;
		int totalCount = 0;
		if(countryCovidList.size()>0) {
			if(countryCovidList.size()%2==1) {
				totalCount = countryCovidList.size()-1;
			}
			else {
				totalCount = countryCovidList.size();
			}
			logger.info("SERVICE:: Total country list to show: "+totalCount);
			for(int i=0; i<=totalCount-1; i++) {

				if(i%2==0) {
					l = new ArrayList<>();
					l.add(countryCovidList.get(i));
				}
				else {
					l.add(countryCovidList.get(i));
					listCCList.add(l);
				}
			}
		}
		else {
			listCCList = null;
		}
		logger.info("END SERVICE:: For country covid 19 results.");
		return listCCList;
		
	}
	
	public List<IndiaCovid> getIndiaCovid(){
		logger.info("START SERVICE:: For India covid 19 results. URL1");
		IndiaCovid[] arr = restTemplate.getForObject(env.getProperty("covid.india.main"), IndiaCovid[].class);
		logger.info("END SERVICE:: For India covid 19 results. URL1");
		return Arrays.asList(arr);
	}
	public IndiaCovidOther getIndiaCovidOther(){
		logger.info("START SERVICE:: For India covid 19 results. URL2");
		IndiaCovidOther ico = restTemplate.getForObject(env.getProperty("covid.india.other"), IndiaCovidOther.class);
		logger.info("END SERVICE:: For India covid 19 results. URL2");
		return ico;
	}

}
