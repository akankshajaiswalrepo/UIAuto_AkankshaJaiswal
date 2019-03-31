# UIAuto_AkankshaJaiswal

Test automation Suite design

a)	Used Selenium framework with Java
b)	It is a maven project
c)	Implemented BDD approach using cucumber libraries
d)	Segregated tests under different category like smoke, ui-test, positive, negative, 
    module specific like registration etc using annotations

e)	For reporting, I have used Extend-report. 
    Path :  <project location>/ExtentReport/report.html
    Screenshots at path: <project location>/screenshots
    
f)	For browser, need to update env.json at location: 
    <project location>/src/test/resources/config/env.json 
    e.g: 
		  "browser": "htmlunit"
		  "browser": "firefox"
		  "browser": "chrome"

g)	Delete API (/user/all Delete all users) is used as a pre-requisite and post steps of this 
    automation pack to clean up the data, before and after execution.
	  Method written is: CommonSteps.sendDeleteRequest();
	  Using RestAssured library.

h)	Executing Test Suite:
    Using CucumberRunnerTest File: Import this project in any ide (eclipse or InteliJ)
    as maven project and wait for the dependencies to download. Java 11 and Apache Maven
    3.6.0 are used while working on this project.
    Navigate to CucumberRunnerTest.java at location:  
    /src/test/java/stepDefs/CucumberRunnerTest.java. RightClick and Run.

    Using command line
    Navigate to the project path of project UI_TestAutomation and run command:
    mvn test -Dcucumber.optins="--tags @uitest"



