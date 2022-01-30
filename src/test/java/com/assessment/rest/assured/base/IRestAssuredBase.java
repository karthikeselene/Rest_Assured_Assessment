package com.assessment.rest.assured.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public interface IRestAssuredBase {
	
	public void setBaseUri(String bUri);
	
	public RequestSpecification sendRequest();
	
	public Object getResponseValue(Response response, String jsonPath);
	
	public int getArraySize(Response response, String jsonPath);

}