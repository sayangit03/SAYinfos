package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.beans.AllServices;
import com.spring.repository.AllServiceRepository;
import com.spring.resource.MailService;

@Service
public class AllServicesservice {

	@Autowired
	AllServiceRepository allServiceRepo;

	@Autowired
	MailService mailService;

	@Value("${mail.toaddress}")
	String toAddress;

	private static Logger logger = LoggerFactory.getLogger(AllServicesservice.class);

	Runnable runnableShutdownMailService = new Runnable() {
		@Override
		public void run() {
			mailService.sendEmail(toAddress, "SAYinfos Website Shutdown Notification", "Hello Admin, \nShutting down the website temporarily.\n\n\n\n-SAYinfos");
		}
	};

	Runnable runnableStartupMailService = new Runnable() {
		@Override
		public void run() {
			mailService.sendEmail(toAddress, "SAYinfos Website Startup Notification", "Hello Admin, \nStarting up the website.\n\n\n\n-SAYinfos");
		}
	};

	public List<AllServices> getAllServices() {
		List<AllServices> allServiceLIst = allServiceRepo.findAll();
		return allServiceLIst;
	}

	//@Cacheable(cacheNames = "OneService-Cache")
	public List<AllServices> findByServiceURI(String reqURI) {
		return allServiceRepo.findByServiceURI(reqURI);
	}

	//@CacheEvict(cacheNames = "OneService-Cache", allEntries = true)
	public boolean stopService(int id) {
		logger.info("Stop Service called. Id: "+id);
		if(id==15) {
			new Thread(runnableShutdownMailService).start();
		}
		Optional<AllServices> allService = allServiceRepo.findById(id);
		if(allService.isPresent()) {
			allService.get().setServiceStatus(false);
			allServiceRepo.save(allService.get());

			return true;
		}
		return false;
	}

	//@CacheEvict(cacheNames = "OneService-Cache", allEntries = true)
	public boolean startService(int id) {
		logger.info("Start Service called. Id: "+id);
		if(id==15) {
			new Thread(runnableStartupMailService).start();
		}
		Optional<AllServices> allService = allServiceRepo.findById(id);
		if(allService.isPresent()) {
			allService.get().setServiceStatus(true);
			allServiceRepo.save(allService.get());

			return true;
		}
		return false;
	}
}
