package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.Contribution;
import com.spring.repository.ContributionRepository;

@Service
public class CookingService {

	@Autowired
	ContributionRepository contriRepo;
	
	public List<Contribution> getAllRecipes(String domain){
		List<Contribution> recipeList = contriRepo.findByContriDomain(domain);
		return recipeList;
	}
}
