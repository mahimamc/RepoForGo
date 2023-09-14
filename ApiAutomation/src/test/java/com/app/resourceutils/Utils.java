package com.app.resourceutils;

import com.app.pojo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
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
	

}
