package com.assessment.rest.assured.projects.spec;

import java.util.HashMap;
import java.util.Map;

import com.assessment.rest.assured.base.HttpMethods;

public class ProjectSpecificationMethods extends HttpMethods {
	
	public Map<String, String> getHeaders(String apikey) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "apikey "+apikey);
		headers.put("Content-Type", "application/json");
		return headers;
	}

}