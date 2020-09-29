package com.spring.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.beans.User;
import com.spring.beans.UserDetails;
import com.spring.beans.UserRegDetails;
import com.spring.fallback.service.FallbackUserService;

@FeignClient(name = "user-service", url = "${microservice.user.service}", fallback = FallbackUserService.class)
public interface FeignUserAndLoginService {

	@GetMapping("/getUserDetails/user/{uniqueName}/pwd/{userPwd}")
	public boolean doLoginFeign(@PathVariable String uniqueName, @PathVariable String userPwd);

	@GetMapping("/getUserDetails")
	public List<UserDetails> getFeignAllApprovedUserDetails();

	@GetMapping("/getRegUserDetails")
	public List<UserRegDetails> getFeignAllRegUserDetails();

	@PostMapping("/userRegistration")
	public String doFeignRegisterUser(@RequestBody User user);

	@GetMapping("/approveAdmin/{email}")
	public String doFeignApproveAdmin(@PathVariable String email);

	@GetMapping("/approveUser/{email}")
	public String doFeignApproveUser(@PathVariable String email);

	@GetMapping("/removeUserFromLogin/{email}")
	public String doFeignRemoveUserFromLogin(@PathVariable String email);
}
