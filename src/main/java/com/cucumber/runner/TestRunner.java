package com.cucumber.runner;

import java.io.File;
import java.io.IOException;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/main/java",
			glue={"com.cucumber.stepDefinitions"},
			plugin={"com.cucumber.listener.ExtentCucumberFormatter:test-output/cucumber-reports/report.html",
					"rerun:test-output/cucumber-reports/rerun.txt"},
			monochrome=true,
			strict=false
			)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	@AfterClass(alwaysRun=true)
	public void writeExtentReport() throws IOException {

		Reporter.loadXMLConfig(new File("src/main/java/com/cucumber/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
	    Reporter.setSystemInfo("Selenium", "3.5.3");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Browser", System.getProperty("browser.useragent"));
	    Reporter.setSystemInfo("Java Version",System.getProperty("java.version"));
	}
}
