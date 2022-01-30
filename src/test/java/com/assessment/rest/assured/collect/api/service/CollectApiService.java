package com.assessment.rest.assured.collect.api.service;

import com.assessment.rest.assured.projects.spec.ProjectSpecificationMethods;
import com.assessment.rest.assured.test.assertion.TestAssertions;
import com.assessment.rest.assured.utils.ReadProperties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CollectApiService extends ProjectSpecificationMethods {

	private Response response = null;

	@Given("UK citizen able can access the collect api to know the covid cases of UK")
	public void uk_citizen_able_can_access_the_collect_api_to_know_the_covid_cases_of_uk() {
		setBaseUri(ReadProperties.readConfig("assessment.api.uri"));
	}

	@When("they hit the get method of the collect api to know the {string} covid cases")
	public void they_hit_the_get_method_of_the_collect_api_to_know_the_covid_cases(String country) {
		response = get(ReadProperties.readConfig("assessment.corona.country.resource"), getHeaders("3kOUS3z1UjXKDsEYelv8DH:5zziLhgrybsWS7OyglFdk3"), "country", country);
		TestAssertions.verifySuccessCode(response, 200);
		TestAssertions.verifySuccessLine(response, "ok");
		TestAssertions.verifyResponseContent(getResponseValue(response, "success"), "true");
	}

	@Then("they able to get the total cases of {string} for the UK country")
	public void they_able_to_get_the_total_cases_of_for_the_uk_country(String totalCases) {
		TestAssertions.verifyArraysize(getArraySize(response, "result"), 1);
		TestAssertions.verifyResponseContent(getResponseValue(response, "result[0].country"), "UK");
		TestAssertions.verifyResponseContent(getResponseValue(response, "result[0].totalCases"), totalCases);
	}
	
	@When("they hit the get method with the invalid {string} query param")
	public void they_hit_the_get_method_with_the_invalid_query_param(String country) {
		response = get(ReadProperties.readConfig("assessment.corona.country.resource"), getHeaders("3kOUS3z1UjXKDsEYelv8DH:5zziLhgrybsWS7OyglFdk3"), "country", country);
		TestAssertions.verifySuccessCode(response, 200);
		TestAssertions.verifySuccessLine(response, "ok");
		TestAssertions.verifyResponseContent(getResponseValue(response, "success"), "true");	    
	}
	
	@When("they able to get the empty corona cases result")
	public void they_able_to_get_the_empty_corona_cases_result() {
		TestAssertions.verifyArraysize(getArraySize(response, "result"), 0);
	}
	
	@When("they hit the get method with unauthorized api to know the {string} covid cases")
	public void they_hit_the_get_method_with_unauthorized_api_to_know_the_covid_cases(String country) {
		response = get(ReadProperties.readConfig("assessment.corona.country.resource"), getHeaders("3kOUS3z1UjXKDsEYelv8DH:5zziLhgrybsWS7OyglFdk31"), "country", country);		
	}
	
	@When("they able to get unauthorized response")
	public void they_able_to_get_unauthorized_response() {
		TestAssertions.verifySuccessCode(response, 401);
		TestAssertions.verifySuccessLine(response, "unauthorized");		
	}

}