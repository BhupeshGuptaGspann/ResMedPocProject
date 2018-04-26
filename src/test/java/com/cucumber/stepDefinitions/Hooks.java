package com.cucumber.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cucumber.core.TestBase;
import com.cucumber.listener.Reporter;
import com.cucumber.utility.TestUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {
	
	private final static Logger log = LogManager.getLogger(TestUtil.class); 
	
	@Before
	public void BeforeSteps()
	{
		log.info("Test Intialization is started...:");
		TestBase.initialization();
	}
	
	@After(order=1)
	public void embedScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			log.info("Scenario is faile..:" +scenario.getName());
			try
			{
				String screenShotName= TestUtil.takeScreenshotAtEndOfTest();
				log.info("Path of Screenshot is.." +screenShotName);
				log.info("Capturing Screenshot of the failed Scenario is..");
				Reporter.addScreenCaptureFromPath(screenShotName);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@After(order=0)
	public void afterSteps()
	{
		driver.quit();
		
	}

}
