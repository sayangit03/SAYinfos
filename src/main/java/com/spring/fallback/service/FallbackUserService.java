package com.spring.fallback.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.beans.User;
import com.spring.beans.UserDetails;
import com.spring.beans.UserRegDetails;
import com.spring.feign.service.FeignUserAndLoginService;

@Component
public class FallbackUserService implements FeignUserAndLoginService {

	@Override
	public boolean doLoginFeign(String uniqueName, String userPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDetails> getFeignAllApprovedUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegDetails> getFeignAllRegUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doFeignRegisterUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doFeignApproveAdmin(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doFeignApproveUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doFeignRemoveUserFromLogin(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
