package com.vytrack.runners;

///runner class is like control panel = > START button
//you can specify what kind of test you want to specify
//like .xml runner in testNg but more simple / easier

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //coming from JUnit
//@RunWith annotation => allows custom task configuration
//cucumber knows how to use it . it will use JUnit and convert those text into executable test during the runtime
@CucumberOptions (
        glue = "com/vytrack/step_definitions", //provides the path to step definition
        features = "src/test/resources/features",
        dryRun = false, //checks if every test step has implementations
        //if there is no step implementation the steps are Useless
        //it will not execute test =. it will just verify if every step is implemented
        // otherwise it will throw exception
        strict = false, //to remove warning in console ??
        tags = "@driver and @dashboard"
        //here we can specify which scenario to run
        //if we make it @sales_manager and @driver = > it will not run because we do not have scenario that has both together
        //if we make it @sales_manager or @ driver =>
        //I think I got it now: if it has sales tag, run it, if it has driver tag, run it, so basically two
)
//why to have 2 tags? : (like driver and store manager in feature file
//when he found a bug I put tag @Bug_VYT4311 (number from Jira)
//it makes it easy to debug the issue / and we will not forget that this story fails and we already reported it
//it indicates that issue is known = to label bugs
//so can this be an appropriate answer to interview question: How do you run only failed test cases in your suite?

//tags = "not @BUG" to quickly run scenarios that area labeled as a bug
//tags = "@BUG"

//parametrasation of text execution
//in TestNG we specify what kind of test we want to run = > this is similar to that
public class CucumberRunner {

}

//failed to parseFeatureFiles => syntax is not correct
//dry run =. is not executing test/ just checking implementation of scenario
//we need to make it false to run test

//are we using the same runner for every feature ? or we change path for that? to run dif. tests?\
//yes we can
//we will group tests later and he will show us how to do so
