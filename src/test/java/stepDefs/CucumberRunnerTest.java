package stepDefs;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import stepDefs.common.CommonSteps;
import stepDefs.common.Hooks;
import utils.Report;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs", "steps"},
        tags = {"@uitest"},
        dryRun = false,
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:ExtentReport/report.html"},
        monochrome = true
)
public class CucumberRunnerTest {
	
	 	@AfterClass
	    public static void teardown() {
		 	Hooks.quitBrowser();
			Reporter.loadXMLConfig(new File(Report.extentConfigPath));
			CommonSteps.sendDeleteRequest();
	    }
}