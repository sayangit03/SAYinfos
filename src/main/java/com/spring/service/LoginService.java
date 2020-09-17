package com.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.beans.Contribution;
import com.spring.beans.FlashUser;
import com.spring.beans.UserDetails;
import com.spring.beans.UserLogin;
import com.spring.beans.UserRegDetails;
import com.spring.repository.ContributionRepository;
import com.spring.repository.FlashUserRepository;

@Service
public class LoginService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment env;

	@Autowired
	ContributionRepository contriRepo;

	@Autowired
	FlashUserRepository flashUserRepo;

	public boolean doLogin(UserLogin user) {
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getUserDetails/user/"+user.getUniqueName()+"/pwd/"+user.getUserPwd();
		String url = env.getProperty("microservice.user.service") + "/getUserDetails/user/" + user.getUniqueName()
				+ "/pwd/" + user.getUserPwd();
		ResponseEntity<Boolean> isLoginOk = restTemplate.getForEntity(url, boolean.class);
		// System.out.println("ok from login service login>>>>>>>
		// "+isLoginOk.getBody()+""+url);
		return isLoginOk.getBody();
	}

	public List<UserDetails> getAllApprovedUserDetails() {
		System.out.println("ok from login service");
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getUserDetails";
		String url = env.getProperty("microservice.user.service") + "/getUserDetails";

		// restTemplate.exchange(url, HttpMethod.GET, UserDetails[].class);
		ResponseEntity<UserDetails[]> details = restTemplate.getForEntity(url, UserDetails[].class);
		// System.out.println(Arrays.asList(details.getBody()).get(0).getLogin().getUniqueName());

		return Arrays.asList(details.getBody());
	}

	public List<UserRegDetails> getAllRegUserDetails() {
		System.out.println("ok from login service");
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getRegUserDetails";
		String url = env.getProperty("microservice.user.service") + "/getRegUserDetails";

		ResponseEntity<UserRegDetails[]> regDetails = restTemplate.getForEntity(url, UserRegDetails[].class);

		return Arrays.asList(regDetails.getBody());
	}

	public List<Contribution> getContributions(String emailId) {
		List<Contribution> list = new ArrayList<>();
		// list = contriRepo.findByUserUniqueName(uniqueName);
		list = contriRepo.findByEmailId(emailId);
		System.out.println("Total questions " + list.size());
		return list;
	}

	public List<FlashUser> getByFlashUserUniqueName() {
		List<FlashUser> list = new ArrayList<>();
		list = flashUserRepo.findAll();
		System.out.println(list.size());
		return list;
	}

}
