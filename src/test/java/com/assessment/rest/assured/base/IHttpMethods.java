package com.assessment.rest.assured.base;

import java.util.Map;

import io.restassured.response.Response;

public interface IHttpMethods {
	
	public Response get(String url);
	
	public Response get(String url, Map<String, String> headers, String qParamKey, String qParamValue);
	
	public Response get(String url, String qParamKey, String qParamValue);
	
	public Response get(String url, Map<String, String> qParams);
	
	public Response get(String url, Map<String, String> headers, Map<String, String> qParams);

}