package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.beans.Contribution;
import com.spring.beans.FlashUser;
import com.spring.beans.UserDetails;
import com.spring.beans.UserLogin;
import com.spring.beans.UserRegDetails;
import com.spring.feign.service.FeignUserAndLoginService;
import com.spring.repository.ContributionRepository;
import com.spring.repository.FlashUserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment env;

	@Autowired
	ContributionRepository contriRepo;

	@Autowired
	FlashUserRepository flashUserRepo;

	@Autowired
	FeignUserAndLoginService feignLogin;

	// @HystrixCommand(commandKey = "userServiceCall", fallbackMethod =
	// "doLoginFallback")
	public boolean doLogin(UserLogin user) {
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getUserDetails/user/"+user.getUniqueName()+"/pwd/"+user.getUserPwd();
		// String url = env.getProperty("microservice.user.service") +
		// "/getUserDetails/user/" + user.getUniqueName()+ "/pwd/" + user.getUserPwd();
		// ResponseEntity<Boolean> isLoginOk = restTemplate.getForEntity(url,
		// boolean.class);
		// log.info("ok from login service login>>>>>>>
		// "+isLoginOk.getBody()+""+url);
		// return isLoginOk.getBody();
		return feignLogin.doLoginFeign(user.getUniqueName(), user.getUserPwd());
	}

	// @HystrixCommand(commandKey = "userServiceCall", fallbackMethod =
	// "getAllApprovedUserDetailsFallback")
	public List<UserDetails> getAllApprovedUserDetails() {
		log.info("ok from login service for all approved users");
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getUserDetails";
		// String url = env.getProperty("microservice.user.service") +
		// "/getUserDetails";
		// restTemplate.exchange(url, HttpMethod.GET, UserDetails[].class);
		// ResponseEntity<UserDetails[]> details = restTemplate.getForEntity(url,
		// UserDetails[].class);
		// log.info(Arrays.asList(details.getBody()).get(0).getLogin().getUniqueName());

		// return Arrays.asList(details.getBody());
		return feignLogin.getFeignAllApprovedUserDetails();
	}

	// @HystrixCommand(commandKey = "userServiceCall", fallbackMethod =
	// "getAllRegUserDetailsFallback")
	public List<UserRegDetails> getAllRegUserDetails() {
		log.info("ok from login service for all registered users");
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getRegUserDetails";
		// String url = env.getProperty("microservice.user.service") +
		// "/getRegUserDetails";
		// ResponseEntity<UserRegDetails[]> regDetails = restTemplate.getForEntity(url,
		// UserRegDetails[].class);
		// return Arrays.asList(regDetails.getBody());
		return feignLogin.getFeignAllRegUserDetails();
	}

	public List<Contribution> getContributions(String emailId) {
		List<Contribution> list = new ArrayList<>();
		// list = contriRepo.findByUserUniqueName(uniqueName);
		list = contriRepo.findByEmailId(emailId);
		log.info("Total questions: " + list.size());
		return list;
	}

	public List<FlashUser> getByFlashUserUniqueName() {
		List<FlashUser> list = new ArrayList<>();
		list = flashUserRepo.findAll();
		log.info("Flash user count: " + list.size());
		return list;
	}

	public boolean doLoginFallback(UserLogin user) {
		log.info("Fallback method for login");
		return false;
	}

	public List<UserDetails> getAllApprovedUserDetailsFallback() {
		log.info("Fallback method for approved user details");
		return null;
	}

	public List<UserRegDetails> getAllRegUserDetailsFallback() {
		log.info("Fallback method for registered user details");
		return null;
	}
}
