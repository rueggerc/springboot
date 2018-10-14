package com.rueggerllc.orderservice.cuke.steps;

import org.springframework.http.ResponseEntity;

import com.rueggerllc.orderservice.cuke.integration.SpringBootBaseIntegrationTest;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends SpringBootBaseIntegrationTest {
	
	@When("User Wants to Retrieve All Orders")
	public void user_Wants_to_Retrieve_All_Orders() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		System.out.println("User Wants to Retrieve All Orders");
		System.out.println("====== OrderServiceTester=" + serviceTester);
	}

	@Then("All Orders are Retrieved for User")
	public void all_Orders_are_Retrieved_for_User() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		
		serviceTester.doIt();
		serviceTester.getAllOrders(testRestTemplate);
		
//		ResponseEntity<String> helloResponse = testRestTemplate.getForEntity("/v1/order-service/orders",String.class);
//		System.out.println("HELLO RESPONSE=" + helloResponse.getBody());
//		System.out.println("ALL Orders are Retrieved for User");
//		serviceTester.getAllOrders();
		
	}
	
}
