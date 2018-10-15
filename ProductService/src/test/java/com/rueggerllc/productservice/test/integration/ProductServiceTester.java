package com.rueggerllc.productservice.test.integration;

import org.assertj.core.api.Assertions;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceTester {
	
	public void doIt() {
		System.out.println("DO IT!");
	}
	
	public void getAllProducts(TestRestTemplate testRestTemplate) {
		System.out.println("====== ProductServiceTester.getAllProducgts BEGIN==========");
		ResponseEntity<String> response = testRestTemplate.getForEntity("/v1/product-service/products",String.class);
		System.out.println("GET PRODUCTS RESPONSE=" + response.getBody());
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println("STATUS CODE CHECKS OUT");
		
		Assertions.assertThat(response.getBody()).isNotNull();
		System.out.println("RESPONSE BODY IS OK");
		
	}
	
	
}
