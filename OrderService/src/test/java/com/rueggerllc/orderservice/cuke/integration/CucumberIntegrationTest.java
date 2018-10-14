package com.rueggerllc.orderservice.cuke.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		strict=true,
		dryRun=false,
		tags={"@ordercontroller"},
		glue="com.rueggerllc.orderservice.cuke.steps",
		features="src/test/resources/features",
		plugin= {
          "pretty",
		  "html:target/cucumber-reports/cucumber-pretty",
          "testng:target/cuke/TEST-cucumber-testng.xml",
          "json:target/cuke/cucumber.json"
        }
)
public class CucumberIntegrationTest extends AbstractTestNGCucumberTests {
}