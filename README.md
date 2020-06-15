##To run tests over the jenkins, specify following top-level maven target as a build part:

clean test -Dcucumber.options="--tags @driver"

##you can specify any tags that are available in your project

##To run smoke test use:

clean test -P Smoke

##To start regression execute:

clean test -P Regression
clean test -P Regression -q

##To run feature files in parallel without limiting number of threads:

<parallel>methods</parallel>
<useUnlimitedThreads>true</useUnlimitedThreads>
<includes>
  <include>**/RegressionRunner.java</include>
</includes>



    
 ##To specify browser type, use parameter -Dbrowser=browserType:

     clean test -Dbrowser=firefox

 ##To specify environment, use parameter -Denv=envType

     mvn test -Denv=qa2

## To run regression on qa1 and chrome browser:

     clean test -Dbrowser=chrome -Denv=qa1 -P Regression

## To run smoke test on qa2 and chrome firefox:

     clean test -Dbrowser=firefox -Denv=qa2 -P Smoke

### NOTE: add mvn before every command if you are not running it on Jenkins:

     mvn test -Dbrowser=firefox -Denv=qa2 -P Regression

 ###To read in Java something -Dparam use --> System.getProperty("param")
 
 ###To run regression over selenium grid on default server
 
 clean test -Dbrowser=chrome-remote -P Regression
 
 ###To run regression over selenium grid
 
      clean test -Dbrowser=chrome-remote -P Regression

###To run regression over selenium grid on your own server

clean test -Dbrowser=chrome-remote -Dgrid_url=http://ip:4444/wd/hub -P Regression
###List of parameters -Dbrowser

-Dgrid_url

-Denv

###Example:

mvn clean test -Dbrowser=chrome-remote -Dgrid_url=http://35.171.158.59:4444/wd/hub -Denv=qa3 -P Smoke -q

#Cybertek Grid info: http://35.171.158.59:4444/wd/hub



to specify browser type from terminal : mvn test -Dbrowser=firefox
it gives power to create 3 different jobs on Jenkins and NOT changing the source code
but specifying the browser and environment , so that 3 jobs can run at the same time in parallel

how many jobs we can run on Jenkins at the same time ? or it depends on the memory /power of the server ? 
depends on power : but also jenkins can have jenkins nodes and distribute job to them 