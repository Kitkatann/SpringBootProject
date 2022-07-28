package com.software.institute.kathb.springbootdemo.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "src/test/resources/cucumber",
        glue = "src/test/java/com/institute/kathb/springbootdemo/cucumber/StepDefinitions.java" )
public class RunCucumberTest {

}
