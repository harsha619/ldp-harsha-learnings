package com.bdd.cucumber.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/login.feature", // Path to your feature files
        glue = "com/bdd/cucumber/steps", // Package containing your step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"} // Output reports
)
public class TestRunner {
}