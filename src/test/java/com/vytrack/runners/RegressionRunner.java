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
        tags = "not @smoke_test", //include all BUT exclude smoke test
        plugin = {
                "html:target/default-report-for-regression",
                "json:target/cucumber_regression.json",
                "rerun:target/rerun_regression.txt"
                //this plugin for generate txt file that shows us which scenario has failed in regression ONLY
        }

)
public class RegressionRunner { //special runner for regression only
}

//took me 26 min  to run my regression in firefox :( and all tests were skipped!!
// ConnectException ( look it up why)
//command used :clean test -Dbrowser=firefox -Denv=qa1 -P Regression -q
