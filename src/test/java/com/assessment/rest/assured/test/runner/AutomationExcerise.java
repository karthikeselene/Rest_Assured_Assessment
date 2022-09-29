package com.assessment.rest.assured.test.runner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;

public class AutomationExcerise {

	public static void main(String[] args) {
		String response = given()				
				.formParam("name", "Paul Hamment")
				.formParam("email", "hamment2@gmail.com")
				.formParam("password", "Qwerty%4321")
				.formParam("title", "Mr")
				.formParam("birth_date", 1)
				.formParam("birth_month", 1)
				.formParam("birth_year", 1982)
				.formParam("firstname", "Paul")
				.formParam("lastname", "Hamment")
				.formParam("address1", "41, 1st Flooor")
				.formParam("country", "India")
				.formParam("zipcode", "600096")
				.formParam("state", "Tamil Nadu")
				.formParam("city", "Chennai")
				.formParam("mobile_number", "9182736451").
				when()
				.post("https://automationexercise.com/api/createAccount")
				.asString();				
		
		System.out.println(response);
		
		JsonPath json = new JsonPath(response);
		assertThat(json.getInt("responseCode"), is(equalTo(201)));
		assertThat(json.getString("message"), is(equalTo("User created!")));
	}

}