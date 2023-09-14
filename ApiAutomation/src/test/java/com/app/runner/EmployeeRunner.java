package com.app.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(
					features= {"src/test/java/com/app/feature"},
					glue= {"com.app.stepdef"},
					plugin= {
							
							"pretty","json:target/cucumberRep.json",
							"html:target/cucumber/cucumberhtml-report"
							
							}
		
				)
public class EmployeeRunner {

}
