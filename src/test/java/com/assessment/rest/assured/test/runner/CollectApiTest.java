package com.assessment.rest.assured.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(		
		          features = "src/test/java/com/assessment/rest/assured/features/CoronaDataService.feature",
		          glue = "com.assessment.rest.assured.collect.api.service",
		          monochrome = true,
		          dryRun = false,
		          plugin = {
		        		     "pretty",
		        		     "json:src/test/resources/Reports/cucumber.json",
		        		     "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		        		   }
				        		    
		        )

public class CollectApiTest extends AbstractTestNGCucumberTests {

}