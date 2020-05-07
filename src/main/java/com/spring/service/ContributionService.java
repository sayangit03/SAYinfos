package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.Contribution;
import com.spring.repository.ContributionRepository;

@Service
public class ContributionService {

	@Autowired
	ContributionRepository contriRepo;
	
	public void saveContribution(Contribution contri) {
		contriRepo.save(contri);
	}
	
	public List<Contribution> getUserContributions(String emailId){
		List<Contribution> list = new ArrayList<>();
		list = contriRepo.findByEmailId(emailId);
		return list;
	}
}
