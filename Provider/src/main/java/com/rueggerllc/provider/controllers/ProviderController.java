package com.rueggerllc.provider.controllers;

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
public class ProviderController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// GET Data
	@GetMapping("/providerdata")
	public String getData() {
		logger.info("============ Get Provider Data BEGIN ==============");
		logger.info("============ Get Provider Data END ==============");
		return "Ruegger Here is the Provider Data";
	}
	

}
