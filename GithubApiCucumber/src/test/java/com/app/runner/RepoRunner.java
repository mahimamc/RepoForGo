package com.app.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/com/app/feature"},
			glue={"com.app.stepdef"},
			dryRun=false,
			monochrome=true,		
			plugin= {
							
							"pretty","json:target/cucumberRep.json",
							"html:target/cucumber/cucumberhtml-report"
							
					}
			)
public class RepoRunner {

}
