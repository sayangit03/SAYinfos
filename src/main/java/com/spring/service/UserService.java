package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.beans.User;
import com.spring.feign.service.FeignUserAndLoginService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment env;

	@Autowired
	FeignUserAndLoginService feignUser;

	public String registerUser(User user) {

		user.setStatus(false);
		log.info("Registration started for: " + user.getName() + " | " + user.getEmail() + " | " + user.getLocation()
				+ " | " + user.getPhone() + " | " + user.getPassword() + " | " + user.isStatus());
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/userRegistration";
		// String url = env.getProperty("microservice.user.service") +
		// "/userRegistration";
		// HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		// HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);

		String res = feignUser.doFeignRegisterUser(user);

		log.info(res);
		if (res.contains("Done")) {
			return "okreg";
		}
		return "notokreg";
	}

	public String approveAdmin(String email) {
		log.info("web user service approve admin email: " + email);
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveAdmin/"+email;
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveAdmin/"+email;
		// String url = env.getProperty("microservice.user.service") + "/approveAdmin/"
		// + email;
		// ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);

		String res = feignUser.doFeignApproveAdmin(email);
		log.info("Approving admin | " + res);
		if (res != null && res.startsWith("Approved")) {
			return res.replace("Approved", "");
		}
		return res;
	}

	public String approveUser(String email) {
		log.info("web user service approve user email: " + email);
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveAdmin/"+email;
		// String url =
		// "http://user-service-sayinfos.us-east-2.elasticbeanstalk.com/approveUser/"+email;
		// String url = env.getProperty("microservice.user.service") + "/approveUser/" +
		// email;
		// ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);

		String res = feignUser.doFeignApproveUser(email);
		log.info("Approving user | " + res);
		if (res != null && res.toString().startsWith("Approved")) {
			return res.replace("Approved", "");
		}
		return res;
	}

	public String removeLogin(String email) {
		log.info("web user service remove user from login: " + email);
		// String url = env.getProperty("microservice.user.service") +
		// "/removeUserFromLogin/" + email;
		// ResponseEntity<String> res = restTemplate.getForEntity(url, String.class);
		return feignUser.doFeignRemoveUserFromLogin(email);
	}
}
