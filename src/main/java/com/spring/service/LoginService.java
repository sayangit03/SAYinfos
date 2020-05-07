package com.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.beans.Contribution;
import com.spring.beans.User;
import com.spring.beans.UserDetails;
import com.spring.beans.UserLogin;
import com.spring.beans.UserRegDetails;
import com.spring.repository.ContributionRepository;

@Service
public class LoginService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ContributionRepository contriRepo;
	
	public boolean doLogin(UserLogin user) {
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getUserDetails/user/"+user.getUniqueName()+"/pwd/"+user.getUserPwd();
		String url = "http://ec2-52-14-32-213.us-east-2.compute.amazonaws.com:8080/user-service/getUserDetails/user/"+user.getUniqueName()+"/pwd/"+user.getUserPwd();
		ResponseEntity<Boolean> isLoginOk = restTemplate.getForEntity(url, boolean.class);
		//System.out.println("ok from login service login>>>>>>> "+isLoginOk.getBody()+""+url);
		return isLoginOk.getBody();
	}
	
	public List<UserDetails> getAllApprovedUserDetails() {
		System.out.println("ok from login service");
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getUserDetails";
		String url = "http://ec2-52-14-32-213.us-east-2.compute.amazonaws.com:8080/user-service/getUserDetails";
		
		//restTemplate.exchange(url, HttpMethod.GET,  UserDetails[].class);
		ResponseEntity<UserDetails[]> details = restTemplate.getForEntity(url, UserDetails[].class);
		//System.out.println(Arrays.asList(details.getBody()).get(0).getLogin().getUniqueName());
		
		return Arrays.asList(details.getBody());
	}
	
	public List<UserRegDetails> getAllRegUserDetails() {
		System.out.println("ok from login service");
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/getRegUserDetails";
		String url = "http://ec2-52-14-32-213.us-east-2.compute.amazonaws.com:8080/user-service/getRegUserDetails";
		
		ResponseEntity<UserRegDetails[]> regDetails = restTemplate.getForEntity(url, UserRegDetails[].class);
		
		return Arrays.asList(regDetails.getBody());
	}
	
	public List<Contribution> getContributions(String uniqueName){
		List<Contribution> list = new ArrayList<>();
		list = contriRepo.findByUserUniqueName(uniqueName);
		System.out.println("Total questions "+list.size());
		return list;
	}
}
