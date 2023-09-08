package com.app.stepdef;

public class CreateURL {
	
	public final static String baseURI="https://api.github.com/";
	
	public String getBaseURI()
	{
		return baseURI;
	}
	public String getBaseURI(String resource)
	{
		return baseURI+resource;
	}

}
