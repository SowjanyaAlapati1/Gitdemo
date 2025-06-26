package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber", glue="Stepdefinitions",monochrome=true, plugin= {"html:target/cucumber.html"}, tags ="@smoke")
public class TestRunner extends AbstractTestNGCucumberTests{

}
