package com.vytrack.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "@target/rerun.txt",
        plugin = {
                "html:target/failed-default-report", //separate report from regular text execution = > to not mix them up
                "json:target/failed_report.json"
        }
)
public class FailedRunner extends AbstractTestNGCucumberTests {
    //this class will rerun the failed tests
    // NO TAGS needed
    // NO dryRun needed
}
