package com.app.resourceutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

				
			String base_URI="https://api.github.com";
			String bearer_token="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";
			Response response;
			RequestSpecification requestSpecification;
		
		
			public Response postRequest(String resourcePath,String payLoad)
			{
					
				
				requestSpecification=RestAssured.given().body(payLoad);
				requestSpecification.contentType(ContentType.JSON);
				requestSpecification.header("Authorization","Bearer "+bearer_token);
				response=requestSpecification.post(base_URI+resourcePath);
				return response;
			}
			public Response deleteRequest(String resourcePath,String repo_name)
			{
					
				String requestURI=base_URI+resourcePath+repo_name;
				requestSpecification=RestAssured.given();
				requestSpecification.contentType(ContentType.JSON);
				requestSpecification.header("Authorization","Bearer "+bearer_token);
				response=requestSpecification.delete(requestURI);
				return response;
				
			}
			
}
