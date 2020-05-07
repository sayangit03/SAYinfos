package com.spring.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

import com.spring.resource.CovidResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.controller", "com.spring.resource", "com.spring.service"})
@EnableJpaRepositories("com.spring.repository")
@EntityScan("com.spring.beans")
public class MyWebApplication01Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication01Application.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyWebApplication01Application.class);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*
	 * @Bean public CovidResource getCovidResource() { return new CovidResource(); }
	 */
}