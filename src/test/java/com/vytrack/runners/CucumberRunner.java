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
        strict = true //to remove warning in console ??

)
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
