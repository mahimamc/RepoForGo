package com.app.resourceutils;

import java.util.Arrays;

import com.app.pojo.Employee;
import com.app.resource.TestDataBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
		
		
		RequestSpecification requestSpecification;
		Response response;
		String baseURI="http://localhost:9090";
		ObjectMapper objectMapper;
		public static String payLoad;
		TestDataBuilder data=new TestDataBuilder();
				
		public Response postRequest(String resourcePath,String payLoad) {
			
			
			requestSpecification=RestAssured.given().body(payLoad);
			requestSpecification.contentType(ContentType.JSON);
			response=requestSpecification.post(baseURI+resourcePath);
			return response;
		}
		public Response getAllEmployee(String resourcePath)
		{
			
				
			requestSpecification=RestAssured.given();
			requestSpecification.contentType(ContentType.JSON);
			response=requestSpecification.get(baseURI+resourcePath);
			return response;
			
		}
		public Response getEmployeeById(String resourcePath,int empId)
		{
			
				
			requestSpecification=RestAssured.given();
			requestSpecification.contentType(ContentType.JSON);
			response=requestSpecification.get(baseURI+resourcePath+empId);
			return response;
			
		}
		public Response updateEmployeeById(String resourcePath,int empId) throws JsonMappingException, JsonProcessingException
		{
			
				
			requestSpecification=RestAssured.given();
			requestSpecification.contentType(ContentType.JSON);
			response=requestSpecification.get(baseURI+resourcePath+empId);
			objectMapper=new ObjectMapper();
			Employee empObj=objectMapper.readValue(response.getBody().asString(),Employee.class);
			System.out.println(empObj.getFirstName());
			System.out.println(empObj.getLastName());
			System.out.println(empObj.getEmailId());
			empObj.setEmailId("martin@outlook.com");
			
			objectMapper=new ObjectMapper();
			payLoad=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data.createEmployeePayload());
			payLoad=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empObj);
			//String empObj=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBody().asString());
			requestSpecification=RestAssured.given().body(payLoad);
			requestSpecification.contentType(ContentType.JSON);
			response=requestSpecification.put(baseURI+resourcePath+empId);			
			//System.out.println(response.getBody().asString());
			return response;
			
		}
		public Response deleteEmployeeById(String resourcePath,int empId) throws JsonMappingException, JsonProcessingException
		{
			
				
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
			return response;
			
		}
	

}
