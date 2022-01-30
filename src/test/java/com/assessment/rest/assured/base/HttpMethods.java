package com.assessment.rest.assured.base;

import java.util.Map;

import io.restassured.response.Response;

public class HttpMethods extends RestAssuredBase implements IHttpMethods{

	public Response get(String url) {
		return sendRequest().get(url);
	}

	public Response get(String url, String qParamKey, String qParamValue) {		
		return sendRequest().queryParam(qParamKey, qParamValue)
				.get(url);
	}

	public Response get(String url, Map<String, String> qParams) {		
		return sendRequest().queryParams(qParams)
				.get(url);
	}

	public Response get(String url, Map<String, String> headers, String qParamKey, String qParamValue) {		
		return sendRequest().headers(headers).queryParam(qParamKey, qParamValue)
				.get(url);
	}

	public Response get(String url, Map<String, String> headers, Map<String, String> qParams) {
		return sendRequest().headers(headers).queryParams(qParams)
				.get(url);
	}
	
	

}