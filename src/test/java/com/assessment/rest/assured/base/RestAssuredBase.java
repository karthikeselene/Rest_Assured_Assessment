package com.assessment.rest.assured.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase implements IRestAssuredBase {	
	
	public void setBaseUri(String bUri) {
		RestAssured.baseURI = bUri;
	}

	public RequestSpecification sendRequest() {		
		return RestAssured.given();
	}

	public Object getResponseValue(Response response, String jsonPath) {		
		return response.jsonPath().get(jsonPath);
	}
	
	public int getArraySize(Response response, String jsonPath) {
		return response.jsonPath().getList(jsonPath).size();
	}

}