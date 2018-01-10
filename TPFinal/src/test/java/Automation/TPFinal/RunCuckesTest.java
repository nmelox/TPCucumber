package Automation.TPFinal;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/bookdepository.feature", glue = "steps", plugin = { "pretty",
        "html:target/site/cucumber-pretty", "json:target/cucumber1.json" })
public class RunCuckesTest extends AbstractTestNGCucumberTests{}
