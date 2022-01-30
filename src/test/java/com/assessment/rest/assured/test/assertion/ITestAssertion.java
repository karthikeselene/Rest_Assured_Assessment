package com.assessment.rest.assured.test.assertion;

import io.restassured.response.Response;

public interface ITestAssertion {
	
	public void verifySuccessCode(Response response, int eCode);
	
	public void verifySuccessLine(Response response, String eValue);
	
	public void verifyArraysize(int eValue, int aValue);
	
	public void verifyResponseContent(Object eValue, String aValue);

}
