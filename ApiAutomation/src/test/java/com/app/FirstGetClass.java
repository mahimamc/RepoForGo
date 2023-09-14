package com.app;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetClass {

		
		
		@Test
		public void getTest()
		{
			
			Response response=RestAssured.get("https://reqres.in/api/users?page=2");
			System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
		}
		
		
}
