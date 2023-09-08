package com.app.resource;

import com.app.pojo.CreateRepoPojo;

public class TestDataBuilder {
		
		CreateRepoPojo reqPayLoad=new CreateRepoPojo();
		
		public CreateRepoPojo createRepoPayLoad()
		{
			
			reqPayLoad.setName("API_Testing_Go1");
			reqPayLoad.setDescription("API Repo Created for Go Telcom");
			return reqPayLoad;
		}
		public String getRepoName()
		{
			
			return reqPayLoad.getName();
		}
		
}
