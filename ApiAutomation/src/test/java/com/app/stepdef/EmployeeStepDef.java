package com.app.stepdef;

import org.springframework.test.web.reactive.server.WebTestClient.RequestBodyUriSpec;

import com.app.pojo.Employee;
import com.app.resource.TestDataBuilder;
import com.app.resourceutils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeStepDef extends Utils{
	
		
		
		ObjectMapper objectMapper;
		Response response;
		String baseURI="http://localhost:9090";
		RequestSpecification requestSpecification;
		public static String payLoad;
		TestDataBuilder data=new TestDataBuilder();
	
	@Given("create the employee payload")
	public void create_the_employee_payload() throws JsonProcessingException {
		
		
	    System.out.println("The api is running");        
	    
	    objectMapper=new ObjectMapper();
	    payLoad=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.createEmployeePayload());
	    
	    
	}
	@When("the user calls {string} with post api call")
	public void the_user_calls_with_post_api_call(String resourcePath) {
		
		response=postRequest(resourcePath, payLoad);
	    
	}
	@Then("the api call get successful with status code {int}")
	public void the_api_call_get_successful_with_status_code(int status_code) {

			
			assertEquals(status_code,response.getStatusCode());

		
	}
	@When("the user calls {string} with get api call")
	public void the_user_calls_with_get_api_call(String resourcePath) {
		
		response=getAllEmployee(resourcePath);		
		Arrays.asList(response.getBody().asString()).stream().forEach(System.out::println);
	    
	}
	@When("the user calls {string} with get api call with id {int}")
	public void the_user_calls_with_get_api_call(String resourcePath,int empId) {
		
		response=getEmployeeById(resourcePath,empId);		
		Arrays.asList(response.getBody().asString()).stream().forEach(System.out::println);
	    
	}
	@When("the user calls {string} with put api call with id {int}")
	public void the_user_calls_with_put_api_call(String resourcePath, int empId) throws JsonMappingException, JsonProcessingException {
			
		
		response=updateEmployeeById(resourcePath, empId);
		Arrays.asList(response.getBody().asString()).stream().forEach(System.out::println);
	    
	}
	@When("the user calls {string} with delete api call with id {int}")
	public void the_user_calls_with_delete_api_call(String resourcePath, int empId) throws JsonMappingException, JsonProcessingException {
		
				
		response=deleteEmployeeById(resourcePath, empId);
		Arrays.asList(response.getBody().asString()).stream().forEach(System.out::println);
	    
	}



}
