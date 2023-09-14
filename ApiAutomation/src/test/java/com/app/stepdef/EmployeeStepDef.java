package com.app.stepdef;

import org.springframework.test.web.reactive.server.WebTestClient.RequestBodyUriSpec;

import com.app.pojo.Employee;
import com.app.resource.TestDataBuilder;
import com.app.resourceutils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.*;

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
		System.out.println(response.getBody().asString());
	    
	}
	@When("the user calls {string} with get api call with id {int}")
	public void the_user_calls_with_get_api_call(String resourcePath,int empId) {
		
		response=getEmployeeById(resourcePath,empId);
		System.out.println(response.getBody().asString());
	    
	}
	@When("the user calls {string} with put api call with id {int}")
	public void the_user_calls_with_put_api_call(String resourcePath, int empId) throws JsonMappingException, JsonProcessingException {
				
		
		requestSpecification=RestAssured.given().body(payLoad);
		requestSpecification.contentType(ContentType.JSON);
		response=requestSpecification.get(baseURI+resourcePath+empId);		
		objectMapper=new ObjectMapper();
		Employee empObj=objectMapper.readValue(response.getBody().asString(),Employee.class);
		System.out.println(empObj.getFirstName());
		System.out.println(empObj.getLastName());
		System.out.println(empObj.getEmailId());
		empObj.setEmailId("markwaugh@gmail.com");
		objectMapper=new ObjectMapper();
		payLoad=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empObj);
		//String empObj=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBody().asString());
		requestSpecification=RestAssured.given().body(payLoad);
		requestSpecification.contentType(ContentType.JSON);
		response=requestSpecification.put(baseURI+resourcePath+empId);
		System.out.println(response.getBody().asString());
	    
	}
	@When("the user calls {string} with delete api call with id {int}")
	public void the_user_calls_with_delete_api_call(String resourcePath, int empId) throws JsonMappingException, JsonProcessingException {
		
		
		
		requestSpecification=RestAssured.given().body(payLoad);
		requestSpecification.contentType(ContentType.JSON);
		response=requestSpecification.get(baseURI+resourcePath+empId);		
		objectMapper=new ObjectMapper();
		Employee empObj=objectMapper.readValue(response.getBody().asString(),Employee.class);		
		objectMapper=new ObjectMapper();
		payLoad=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empObj);		
		requestSpecification=RestAssured.given().body(payLoad);
		requestSpecification.contentType(ContentType.JSON);
		response=requestSpecification.delete(baseURI+resourcePath+empId);
		System.out.println(response.getBody().asString());
	    
	}



}
