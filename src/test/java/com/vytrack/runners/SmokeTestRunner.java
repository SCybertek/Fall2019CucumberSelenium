package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "@smoke_test",
        plugin = {
                "html:target/smoke_test_default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt" //this plugin for generate txt file that shows us which scenario has failed
        }

)
public class SmokeTestRunner {
        //profile in Selenium : it is creating preconfigured build inside the profile.

        //we have dif. profile in Pom that has id : Smoke (that is preconfigured)
        //and we have runner class that is targeting Smoke feature
        //in your terminal : mvn clean test -P <Smoke>
        //creating another build configurations is an alternative for :
        // mvn clean verify -Dcucumber.options=“--tags @smoke_test”


}
