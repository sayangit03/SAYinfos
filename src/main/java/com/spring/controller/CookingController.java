package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.beans.Contribution;
import com.spring.service.CookingService;

@Controller
public class CookingController {

	@Autowired
	CookingService cookingService;

	@GetMapping("/cooking")
	public String getRecipes(ModelMap modelMap) {
		List<Contribution> recipeList = cookingService.getAllRecipes("Cooking Recipe");
		
		List<Contribution> breakfastList = new ArrayList<>();
		List<Contribution> lunchtList = new ArrayList<>();
		List<Contribution> snacksList = new ArrayList<>();
		List<Contribution> dinnerList = new ArrayList<>();
		
		for(Contribution c :recipeList) {
			if(c.isContriStatus()) {
				if(c.getContriTopic().equalsIgnoreCase("breakfast")) {
					breakfastList.add(c);
				}
				if(c.getContriTopic().equalsIgnoreCase("lunch")) {
					lunchtList.add(c);
				}
				if(c.getContriTopic().equalsIgnoreCase("snacks")) {
					snacksList.add(c);
				}
				if(c.getContriTopic().equalsIgnoreCase("dinner")) {
					dinnerList.add(c);
				}
			}
		}
		
		if(breakfastList!=null && breakfastList.size()>0) {
			for(int i=0; i<breakfastList.size(); i++) {
				breakfastList.get(i).setId(i+1);
			}
		}
		if(lunchtList!=null && lunchtList.size()>0) {
			for(int i=0; i<lunchtList.size(); i++) {
				lunchtList.get(i).setId(i+1);
			}
		}
		if(snacksList!=null && snacksList.size()>0) {
			for(int i=0; i<snacksList.size(); i++) {
				snacksList.get(i).setId(i+1);
			}
		}
		if(dinnerList!=null && dinnerList.size()>0) {
			for(int i=0; i<dinnerList.size(); i++) {
				dinnerList.get(i).setId(i+1);
			}
		}
		System.out.println(breakfastList.size()+"b size l"+lunchtList.size());
		modelMap.addAttribute("breakfastList", breakfastList);
		modelMap.addAttribute("lunchtList", lunchtList);
		modelMap.addAttribute("snacksList", snacksList);
		modelMap.addAttribute("dinnerList", dinnerList);
		return "cooking_recipe";
	}
}
