package com.app.stepdef;

import static org.junit.Assert.assertEquals;

import com.app.resource.TestDataBuilder;
import com.app.resourceutils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RepoStepDef extends Utils{
	
		
	TestDataBuilder data=new TestDataBuilder();
	ObjectMapper objectMapper;		
	JsonPath jsonPath;
	String payLoad;
	Response response;
	
	
	@Given("Create Repo payload")
	public void create_repo_payload() throws JsonProcessingException {
	    				
			objectMapper=new ObjectMapper();
			payLoad=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.createRepoPayLoad());
	    
	}
	@When("User calls {string} post api call")
	public void User_calls_create_repo_post_api_call(String resourcePath) {
	   
			response=postRequest(resourcePath,payLoad);
			System.out.println(response.getBody().asString());
	}
	@Then("api call get successful with status code {int}")
	public void api_call_get_successful_with_status_code(int status_code) {
	    
		assertEquals(status_code,response.getStatusCode());
			
	}
	@When("User calls Delete api {string} post api call")
	public void user_calls_delete_api_post_api_call(String resourcePath) {
		
	    	response=deleteRequest(resourcePath,data.getRepoName());
	    	System.out.println("Status Code is"+response.getStatusCode());
	}

	@Then("Verify Repository {string} is {string}")
	public void Verify_Created(String resp_key,String repo_name){
		
		jsonPath=new JsonPath(response.getBody().asString());
		String key_value=jsonPath.get(resp_key);
		assertEquals(repo_name,key_value);
	}




}
