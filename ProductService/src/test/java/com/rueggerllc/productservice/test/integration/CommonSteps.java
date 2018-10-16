package com.rueggerllc.productservice.test.integration;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends SpringBootBaseIntegrationTest {

	@When("User Wants to Retrieve All Products")
	public void user_Wants_to_Retrieve_All_Products() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		System.out.println("User Wants to Retrieve All Products");
	}

	@Then("All Products are Retrieved for User")
	public void all_Products_are_Retrieved_for_User() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		
		System.out.println("All Producs are Retrieved for User");
		serviceTester.doIt();
		serviceTester.getAllProducts(testRestTemplate);
	}
	
}
