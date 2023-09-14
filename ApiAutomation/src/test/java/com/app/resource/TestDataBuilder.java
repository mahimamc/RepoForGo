package com.app.resource;

import org.apache.groovy.parser.antlr4.GroovyParser.CreatedNameContext;

import com.app.pojo.Employee;

public class TestDataBuilder {

		Employee reqPayload=new Employee();
		
		public Employee createEmployeePayload() {

			reqPayload.setFirstName("Anupama");
		    reqPayload.setLastName("Chhinchani");
		    reqPayload.setEmailId("a@gmail.com");	
		    return reqPayload;
			
		}
		
}
