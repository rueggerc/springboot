package com.rueggerllc.productservice.test.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import com.rueggerllc.productservice.ProductServiceApplication;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT,classes=ProductServiceApplication.class)
@ActiveProfiles("int")
public  abstract class SpringBootBaseIntegrationTest {
	
	@LocalServerPort
	protected int port;
	
	@Autowired
	protected TestRestTemplate testRestTemplate;
	
	@Autowired
	protected ProductServiceTester serviceTester;
	
}
