package com.rueggerllc.consumer.controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ConsumerController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// GET Data
	@GetMapping("/data")
	public String getData() {
		logger.info("============ GetData BEGIN ==============");
		ResponseEntity<String> response = null;
		String data = null;
		try {
			getProfiles();
			List<ServiceInstance> instances = discoveryClient.getInstances("provider");
			ServiceInstance serviceInstance = instances.get(0);
			String baseURL = serviceInstance.getUri().toString();
			logger.info("BASE URL FOR PROVIDER=" + baseURL);
			baseURL = baseURL + "/providerdata";
			logger.info("FINAL URL=" + baseURL);
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.exchange(baseURL, HttpMethod.GET, getHeaders(),String.class);
			data = response.getBody();
			logger.info("PROVIDER DATA=" + data);
			
		} catch (Exception exception) {
			logger.error("ERROR:", exception);
		}
		logger.info("============ GetData END ==============");
		return data;
	}
	
	private void getProfiles() {
		logger.info("===== Profiles BEGIN ===");
		String[] activeProfiles = environment.getActiveProfiles();
		if (activeProfiles != null) {
			for (String profile : activeProfiles) {
				logger.info("Active Profile = " + profile);
			}
		}
		
		logger.info("===== Profiles END ===");
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
	

}
