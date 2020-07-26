package com.spring.controller;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.spring.resource.CovidResource;

//@Profile("dev")
@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.controller", "com.spring.resource", "com.spring.service", "com.spring.filter"})
@EnableJpaRepositories("com.spring.repository")
@EntityScan("com.spring.beans")
//@EnableCaching
@EnableScheduling
public class MyWebApplication03Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication03Application.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyWebApplication03Application.class);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	//Stop scanning the Manifest file i.e. .MF file
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
			}
		};
	}

	/*
	 * @Bean public CovidResource getCovidResource() { return new CovidResource(); }
	 */
}