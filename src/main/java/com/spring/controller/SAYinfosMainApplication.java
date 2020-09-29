/**
 * Project SAYinfos
 */
package com.spring.controller;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

//@Profile("dev")
@SpringBootApplication
@ComponentScan(basePackages = { "com.spring.controller", "com.spring.resource", "com.spring.service",
		"com.spring.filter", "com.spring.fallback.service" })
@EnableMongoRepositories("com.spring.repository")
@EntityScan("com.spring.beans")
//@EnableCaching
@EnableScheduling
@EnableFeignClients("com.spring.feign.service")
@EnableHystrix
//@EnableHystrixDashboard
public class SAYinfosMainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SAYinfosMainApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SAYinfosMainApplication.class);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// Stop scanning the Manifest file i.e. .MF file
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