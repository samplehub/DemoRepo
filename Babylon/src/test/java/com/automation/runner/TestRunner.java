package com.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(monochrome = true, features = { "Resources/features/SignUp.feature", }, glue = {
		"com.automation.testSteps" }

)

public class TestRunner extends AbstractTestNGCucumberTests {

}
