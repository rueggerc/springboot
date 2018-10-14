package com.rueggerllc.orderservice.cuke.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import com.rueggerllc.orderservice.OrderServiceApplication;
import com.rueggerllc.orderservice.cuke.steps.OrderServiceTester;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT,classes=OrderServiceApplication.class)
@ActiveProfiles("int")
public  abstract class SpringBootBaseIntegrationTest {
	
	@LocalServerPort
	protected int port;
	
	@Autowired
	protected TestRestTemplate testRestTemplate;
	
	@Autowired
	protected OrderServiceTester serviceTester;
	
	// @Autowired
	// protected RestTemplate restTemplate;

}
