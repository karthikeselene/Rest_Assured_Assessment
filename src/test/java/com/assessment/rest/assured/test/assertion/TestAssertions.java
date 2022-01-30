package com.assessment.rest.assured.test.assertion;

import org.testng.Assert;

import io.restassured.response.Response;

public class TestAssertions implements ITestAssertion {

	public void verifySuccessCode(Response response, int eCode) {
		try {
			Assert.assertEquals(response.getStatusCode(), eCode);	
			System.out.println("Expeted value <"+eCode+"> matches with the actual one <"+response.getStatusCode()+">");			
		} catch (AssertionError e) {
			System.out.println("Expeted value <"+eCode+"> not matched with the actual one <"+response.getStatusCode()+"> "+e.toString());
		}		
	}

	public void verifySuccessLine(Response response, String eValue) {
		if(response.getStatusLine().toUpperCase().contains(eValue.toUpperCase())) {
			System.out.println("Expeted value <"+eValue+"> matches with the actual one <"+response.getStatusLine()+">");
		} else {
			throw new RuntimeException("Expeted value <"+eValue+"> not matched with the actual one <"+response.getStatusLine()+"> ");
		}
	}

	public void verifyArraysize(int eValue, int aValue) {
		try {
			Assert.assertEquals(eValue, aValue);	
			System.out.println("Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");			
		} catch (AssertionError e) {
			System.out.println("Expeted value <"+eValue+"> not matched with the actual one <"+aValue+"> "+e.toString());
		}		
	}

	public void verifyResponseContent(Object eValue, String aValue) {
		try {
			Assert.assertEquals(eValue.toString(), aValue);
			System.out.println("Expeted value <"+eValue+"> matches with the actual one <"+aValue+">");
		} catch (AssertionError e) {
			System.out.println("Expeted value <"+eValue+"> not matched with the actual one <"+aValue+"> "+e.toString());
		}		
	}

}