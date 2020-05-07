package com.spring.controller;

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
		if(recipeList!=null && recipeList.size()>0) {
			for(int i=0; i<recipeList.size(); i++) {
				recipeList.get(i).setId(i+1);
			}
		}
		
		modelMap.addAttribute("recipeList", recipeList);
		return "cooking_recipe";
	}
}
