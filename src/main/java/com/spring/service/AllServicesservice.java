package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.beans.AllServices;
import com.spring.repository.AllServiceRepository;

@Service
public class AllServicesservice {

	@Autowired
	AllServiceRepository allServiceRepo;
	
	public List<AllServices> getAllServices() {
		List<AllServices> allServiceLIst = allServiceRepo.findAll();
		return allServiceLIst;
	}
	
	@Cacheable(cacheNames = "OneService-Cache")
	public List<AllServices> findByServiceURI(String reqURI) {
		return allServiceRepo.findByServiceURI(reqURI);
	}
	
	@CacheEvict(cacheNames = "OneService-Cache", allEntries = true)
	public boolean stopService(int id) {
		Optional<AllServices> allService = allServiceRepo.findById(id);
		if(allService.isPresent()) {
			allService.get().setServiceStatus(false);
			allServiceRepo.save(allService.get());
			
			return true;
		}
		return false;
	}
	
	@CacheEvict(cacheNames = "OneService-Cache", allEntries = true)
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
