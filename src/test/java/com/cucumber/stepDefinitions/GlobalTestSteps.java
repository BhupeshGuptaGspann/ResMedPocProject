package com.cucumber.stepDefinitions;

import org.junit.Assert;

import com.cucumber.core.TestBase;
import com.cucumber.listener.Reporter;
import com.cucumber.utility.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GlobalTestSteps extends TestBase {
	
	
	@Given("^User launched ResMed Application$")
	public void user_launched_ResMed_Application()
	{
		Reporter.addStepLog("We are in Background");
//		TestBase.initialization();
		driver.get(prop.getProperty("BaseURL"));
		Reporter.addStepLog("User Landed on the ResMed Application Login Page");
		String page_Title=driver.getTitle();
		System.out.println("Value for page_Title is :: "+page_Title);
	}
	
	@Then("^verify ResApp login page is opened$")
	public void verify_title_of_login_page() throws Throwable 
	{
		String loginPageTitle=TestUtil.getTitle();
		String appTitle="RESMED Online Store";
		Assert.assertEquals(appTitle, loginPageTitle);

	}

}
