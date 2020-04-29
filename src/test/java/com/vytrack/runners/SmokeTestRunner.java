package com.vytrack.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "@scenario_outline_2",
        plugin = {
                "html:target/smoke_test_default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt" //this plugin for generate txt file that shows us which scenario has failed
        }

)
public class SmokeTestRunner extends AbstractTestNGCucumberTests {
        //profile in Selenium : it is creating preconfigured build inside the profile.

        //we have dif. profile in Pom that has id : Smoke (that is preconfigured)
        //and we have runner class that is targeting Smoke feature
        //in your terminal : mvn clean test -P <Smoke>
        //creating another build configurations is an alternative for :
        // mvn clean verify -Dcucumber.options=“--tags @smoke_test”


        //in order to run scenario outline (each row) in parallel - scenarios from same Feature file in parallel
        //we have to override this method coming from AbstractTestNGCucumberTests class
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return super.scenarios();
        }

        //in testNG => scenarios can go through data provider and we can run them at the same time



}
