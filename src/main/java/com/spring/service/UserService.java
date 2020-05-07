package com.spring.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.beans.User;

@Service
public class UserService {

	@Autowired
	RestTemplate restTemplate;
	
	public String registerUser(User user) {
		
		user.setStatus(false);
		System.out.println("ok from service "+user.getName()+" | "+user.getEmail()+" | "+user.getLocation()+" | "+user.getPhone()+" | "+user.getPassword()+" | "+user.isStatus());
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/userRegistration";
		String url = "http://ec2-52-14-32-213.us-east-2.compute.amazonaws.com:8080/user-service/userRegistration";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
		
		String res = restTemplate.postForObject(url, httpEntity, String.class);
		System.out.println(res);
		if(res.contains("Done")) {
			return "okreg";
		}
		return "notokreg";
	}
	
	
	public String approveAdmin(String email) {
		System.out.println("web user service approve email: "+email);
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveAdmin/"+email;
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveAdmin/"+email;
		String url = "http://ec2-52-14-32-213.us-east-2.compute.amazonaws.com:8080/user-service/approveAdmin/"+email;
		
		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
		System.out.println(res.getBody());
		if(res!=null && res.getBody()!=null && res.getBody().toString().startsWith("Approved")) {
			return res.getBody().replace("Approved", "");
		}
		return res.getBody();
	}
	
	public String approveUser(String email) {
		System.out.println("web user service approve email: "+email);
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveAdmin/"+email;
		//String url = "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveUser/"+email;
		String url = "http://ec2-52-14-32-213.us-east-2.compute.amazonaws.com:8080/user-service/approveUser/"+email;
		
		ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
		System.out.println(res.getBody());
		if(res!=null && res.getBody()!=null && res.getBody().toString().startsWith("Approved")) {
			return res.getBody().replace("Approved", "");
		}
		return res.getBody();
	}
}
