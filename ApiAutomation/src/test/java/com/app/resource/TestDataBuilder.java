package com.app.resource;

import org.apache.groovy.parser.antlr4.GroovyParser.CreatedNameContext;

import com.app.pojo.Employee;

public class TestDataBuilder {

		Employee reqPayload=new Employee();
		
		public Employee createEmployeePayload() {

			reqPayload.setFirstName("Andrew");
		    reqPayload.setLastName("Anderson");
		    reqPayload.setEmailId("andrew@gmail.com");	
		    return reqPayload;
			
		}
		
}
