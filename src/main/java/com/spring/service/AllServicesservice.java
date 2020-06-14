package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.AllServices;
import com.spring.repository.AllServiceRepository;

@Service
public class AllServicesservice {

	@Autowired
	AllServiceRepository allServiceRepo;
	
	public List<AllServices> getAllServices() {
		
		
		/*
		 * AllServices allservice = new AllServices();
		 * allservice.setServiceName("Idea Management"); allservice.setServiceHits(0);
		 * allservice.setServiceURI(""); allservice.setServiceStatus(false);
		 * allServiceRepo.save(allservice);
		 * 
		 * AllServices allservice1 = new AllServices();
		 * allservice1.setServiceName("EK Java"); allservice1.setServiceHits(0);
		 * allservice1.setServiceURI("/Java_Basics");
		 * allservice1.setServiceStatus(true); allServiceRepo.save(allservice1);
		 * 
		 * AllServices allservice2 = new AllServices();
		 * allservice2.setServiceName("EK Spring"); allservice2.setServiceHits(0);
		 * allservice2.setServiceURI("/Spring_Core");
		 * allservice2.setServiceStatus(true); allServiceRepo.save(allservice2);
		 * 
		 * AllServices allservice3 = new AllServices();
		 * allservice3.setServiceName("EK Spring Advanced");
		 * allservice3.setServiceURI("/Spring_Boot"); allservice3.setServiceHits(0);
		 * allservice3.setServiceStatus(true); allServiceRepo.save(allservice3);
		 * 
		 * AllServices allservice4 = new AllServices();
		 * allservice4.setServiceName("EK Hibernate"); allservice4.setServiceHits(0);
		 * allservice4.setServiceURI("/Hibernate_Basics");
		 * allservice4.setServiceStatus(true); allServiceRepo.save(allservice4);
		 * 
		 * AllServices allservice5 = new AllServices();
		 * allservice5.setServiceName("Covid19 India & States");
		 * allservice5.setServiceURI("/indiaCovid"); allservice5.setServiceHits(0);
		 * allservice5.setServiceStatus(true); allServiceRepo.save(allservice5);
		 * 
		 * AllServices allservice6 = new AllServices();
		 * allservice6.setServiceName("Covid19 Countries");
		 * allservice6.setServiceURI("/countryCovid"); allservice6.setServiceHits(0);
		 * allservice6.setServiceStatus(true); allServiceRepo.save(allservice6);
		 * 
		 * AllServices allservice7 = new AllServices();
		 * allservice7.setServiceName("Covid19 World"); allservice7.setServiceHits(0);
		 * allservice7.setServiceURI("/worldCovid"); allservice7.setServiceStatus(true);
		 * allServiceRepo.save(allservice7);
		 * 
		 * AllServices allservice8 = new AllServices();
		 * allservice8.setServiceName("Weather Updates"); allservice8.setServiceHits(0);
		 * allservice8.setServiceURI("/weather"); allservice8.setServiceStatus(true);
		 * allServiceRepo.save(allservice8);
		 * 
		 * AllServices allservice9 = new AllServices();
		 * allservice9.setServiceName("Latest News"); allservice9.setServiceHits(0);
		 * allservice9.setServiceURI("/news"); allservice9.setServiceStatus(true);
		 * allServiceRepo.save(allservice9);
		 * 
		 * AllServices allservice10 = new AllServices();
		 * allservice10.setServiceName("Cooking Recipes");
		 * allservice10.setServiceURI("/cooking"); allservice10.setServiceHits(0);
		 * allservice10.setServiceStatus(true); allServiceRepo.save(allservice10);
		 * 
		 * AllServices allservice11 = new AllServices();
		 * allservice11.setServiceName("Registration Service");
		 * allservice11.setServiceURI("/registration"); allservice11.setServiceHits(0);
		 * allservice11.setServiceStatus(true); allServiceRepo.save(allservice11);
		 * 
		 * AllServices allservice12 = new AllServices();
		 * allservice12.setServiceName("Mylogin Service");
		 * allservice12.setServiceURI("/mylogin"); allservice12.setServiceHits(0);
		 * allservice12.setServiceStatus(true); allServiceRepo.save(allservice12);
		 * 
		 * AllServices allservice13 = new AllServices();
		 * allservice13.setServiceName("SSOlogin Service");
		 * allservice13.setServiceURI("/ssoLogin"); allservice13.setServiceHits(0);
		 * allservice13.setServiceStatus(true); allServiceRepo.save(allservice13);
		 * 
		 * AllServices allservice14 = new AllServices();
		 * allservice14.setServiceName("SAYinfos Website");
		 * allservice14.setServiceURI("/"); allservice14.setServiceHits(0);
		 * allservice14.setServiceStatus(true); allServiceRepo.save(allservice14);
		 */
		
		
		List<AllServices> allServiceLIst = allServiceRepo.findAll();
		return allServiceLIst;
	}
	
	public boolean stopService(int id) {
		Optional<AllServices> allService = allServiceRepo.findById(id);
		if(allService.isPresent()) {
			allService.get().setServiceStatus(false);
			allServiceRepo.save(allService.get());
			
			return true;
		}
		return false;
	}
	
	public boolean startService(int id) {
		Optional<AllServices> allService = allServiceRepo.findById(id);
		if(allService.isPresent()) {
			allService.get().setServiceStatus(true);
			allServiceRepo.save(allService.get());
			
			return true;
		}
		return false;
	}
}
