package com.spring.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity security) throws Exception {
		security.csrf().disable()
		.authorizeRequests().antMatchers("/ssoLogin").authenticated().
		
		antMatchers("/**").permitAll();
	}
}
