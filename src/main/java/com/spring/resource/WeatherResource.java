package com.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.beans.Weather;

@Service
public class WeatherResource {
	
	@Autowired
	Environment env;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Weather getWeather(String zip) {
		String url = "http://api.openweathermap.org/data/2.5/forecast?zip=700156,IN&appid="+env.getProperty("weather.key")+"&units=metric";
		if(zip!=null && zip!="") {
			url = "http://api.openweathermap.org/data/2.5/forecast?zip="+zip+",IN&appid="+env.getProperty("weather.key")+"&units=metric";
		}
		System.out.println(url);
		Weather weather = restTemplate.getForObject(url, Weather.class);
		return weather;
	}
}
