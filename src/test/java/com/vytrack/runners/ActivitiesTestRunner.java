package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features/activities",
        dryRun = false,
        strict = false,
        tags = "@view_calendar_events",
        plugin = {"html:target/default-report",
                "json:target/cucumber2.json"
        }
        // we have 2 runner classes right now and each will generate report in 2 separate json files
        //and then they will be merged into html report
)


public class ActivitiesTestRunner {

}






//for dif. components you can have dif runner classes
//and you can run them in parallel (if you have enough performance and set up is good you can run hundreds of test cases even 2000 )
//the maintenance is harder but it is possible