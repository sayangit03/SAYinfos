package com.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.beans.Forecast;
import com.spring.beans.Sorce;
import com.spring.beans.Sys;
import com.spring.beans.Weather;
import com.spring.resource.WeatherResource;

@Controller
public class WeatherController {

	@Autowired
	WeatherResource weatherResource;

	@GetMapping("/weather")
	public String getWeatherForecast(ModelMap modelMap, Sys sys) {
		System.out.println("From weather controller: "+sys.getPod());
		boolean response = true;
		Weather weather = new Weather();
		try {
			weather = weatherResource.getWeather(sys.getPod());

			System.out.println(">>>>>> "+weather.getForecastList().get(0).getDtTxt());




			List<Forecast> forecastList = weather.getForecastList();
			for(Forecast fore : forecastList) {
				String dt = fore.getDtTxt();
				String fnl = null;
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat sdf2 = new SimpleDateFormat("EEE hh aa");
				Date date = null;
				try {
					date = sdf1.parse(dt);
					fnl = sdf2.format(date);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fore.setDtTxt(fnl);
			}

			List<Forecast> forecastList1 = new ArrayList<>();
			List<Forecast> forecastList2 = new ArrayList<>();
			List<Forecast> forecastList3 = new ArrayList<>();
			List<Forecast> forecastList4 = new ArrayList<>();
			List<Forecast> forecastList5 = new ArrayList<>();
			List<Forecast> forecastList6 = new ArrayList<>();
			List<Forecast> forecastList7 = new ArrayList<>();
			List<Forecast> forecastList8 = new ArrayList<>();
			List<Forecast> forecastList9 = new ArrayList<>();
			List<Forecast> forecastList10 = new ArrayList<>();
			if(forecastList.size()>12) {
				forecastList1 = forecastList.subList(0, 4);
				forecastList2 = forecastList.subList(4, 8);
				forecastList3 = forecastList.subList(8, 12);
			}
			if(forecastList.size()>24) {
				forecastList4 = forecastList.subList(12, 16);
				forecastList5 = forecastList.subList(16, 20);
				forecastList6 = forecastList.subList(20, 24);
			}
			if(forecastList.size()>36) {
				forecastList7 = forecastList.subList(24, 28);
				forecastList8 = forecastList.subList(28, 32);
				forecastList9 = forecastList.subList(32, 36);
			}
			if(forecastList.size()==40) {
				forecastList10 = forecastList.subList(36, 40);
			}

			List<List<Forecast>> listForecastList = new ArrayList<>();
			listForecastList.add(forecastList1);
			listForecastList.add(forecastList2);
			listForecastList.add(forecastList3);
			listForecastList.add(forecastList4);
			listForecastList.add(forecastList5);
			listForecastList.add(forecastList6);
			listForecastList.add(forecastList7);
			listForecastList.add(forecastList8);
			listForecastList.add(forecastList9);
			listForecastList.add(forecastList10);

			modelMap.addAttribute("listForecastList", listForecastList);
			modelMap.addAttribute("city", weather.getCity().getName());
		}catch (Exception e) {
			// TODO: handle exception
			response = false;
		}
		modelMap.addAttribute("resp", response);
		return "weather_all";
	}
}
