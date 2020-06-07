package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.beans.AllServices;
import com.spring.service.AllServicesservice;

@Controller
public class AllServiceController {

	@Autowired
	AllServicesservice allServicesService;
	
	@RequestMapping("/cpanel")
	public String showControlPanel(ModelMap modelMap) {
		List<AllServices> allServicesList = allServicesService.getAllServices();
		modelMap.addAttribute("allServicesList", allServicesList);
		return "control_panel";
	}
	
	@RequestMapping("/stopService/{id}")
	public String stopService(@PathVariable int id) {
		allServicesService.stopService(id);
		return "redirect:/cpanel";
	}
	
	@RequestMapping("/startService/{id}")
	public String startService(@PathVariable int id) {
		allServicesService.startService(id);
		return "redirect:/cpanel";
	}
}
