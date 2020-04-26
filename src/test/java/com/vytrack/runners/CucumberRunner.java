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
        features = "src/test/resources",
        dryRun = false,//checks if every test step has implementations
        strict = false,
        //if strict = true ; all unimplemented steps fo scenario will come us ERROR (UnderfinedStepException)
        //if it set to false : it will prompt unimplemented steps in the console NOT ERROR
    //    tags = "@login",
        plugin = {"html:target/default-report",//to generate cucumber html report
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt" //this plugin for rerunning failed tests
        }

        //dry run = is not executing test/ just checking implementation of scenario
        //we need to make it false to run test
        //when DryRun value = true => TO GET STEP DEFINITION Snip it
        //if there is no step implementation the steps are Useless
        //it will not execute test = it will just verify if every step is implemented
        //if there are all implementations present already then SCENARIO will be skipped
        //when value = false => it runs the test
        //io.cucumber.junit.SkippedThrowable: This scenario is skipped => means you have implemented steps but you are running the test in DRY run mode => solution make dry run false


        //Json = javascript annotation language = it is type of file, the language that is used to describe object
        //it looks like plain text
        //every parameter has its own value
        //used heavily in API = because it transfers data (?)
        //our framework generates jason file that contains all scenario pass/fail status, everything! some plagin takes into .. and creates report (beautful one)
        //jason file does not have methods (NO behaviours)
        //ONLY properties!

        //in tags = here we can specify which scenario to run
        //if we make it @sales_manager and @driver = > it will not run because we do not have scenario that has both together
        //if we make it @sales_manager or @ driver =>
        //if it has sales tag, run it, if it has driver tag, run it, so basically two scenario will
)

public class CucumberRunner {

}

//why to have 2 tags? : (like driver and store manager in feature file
//when he found a bug he put tag @Bug_VYT4311 (number from Jira)
//it makes it easy to debug the issue / and we will not forget that this story fails and we already reported it
//it indicates that issue is known = to label bugs
//so can this be an appropriate answer to interview question: How do you run only failed test cases in your suite?

//tags = "not @BUG" to quickly run scenarios that area labeled as a bug
//tags = "@BUG"

//parametrization of text execution
//in TestNG we specify what kind of test we want to run = > this is similar to that

//failed to parseFeatureFiles => syntax is not correct


//are we using the same runner for every feature ? or we change path for that? to run dif. tests?
//yes we can
//we will group tests later and he will show us how to do so





//SEVERE]: Timed out receiving message from renderer: 0.100
//Whoever has this error, it’s all about your current Chrome driver version,
// stable one was 79, but latest is 81, 81 is causing this error,
// you can downgrade or just ignore that error
//System.setProperty("webdriver.chrome.silentOutput", "true"); //THIS will surpress all logs expect INFO

//ClassNOtFound error => solution : delete .idea folder and restart IntelliJ

//failed to parse feature file => meaning syntax in feature file is Wrong

/**
 *notes from Seda:
 * //our framework creates json file, some plugin takes jason file and generates a nice HTML report
 * //json looks like plain text, has "properties,values" , arrays,Strings,integers,
 * //json object vs java object
 * //json object has only properties no method; java object has both properties and methods
 * //We add json plugin => "json:target/cucumber.json" => to let it generate by our framework
 */

//we need surefire plug in = to run the test without IDE
//we need plugin for Json report in our POM.XML

/**
 *To generate reports :
 * From maven click : verfiy
 * Terminal command => mvn verify / mvn test
 * To clean target file and run => mvn clean verify / mvn clean test
 *  mvn clean verify -q => minimize console log
 * *It does not generate report when you run from cucumberRunner
 */

//scenario outline:
// "" => defines parameter in our step definition
//  <> => required by scenario outline where data will be inserted