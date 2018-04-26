package com.cucumber.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.cucumber.core.TestBase;
import com.cucumber.pages.HomePage;
import com.cucumber.pages.LoginPage;
import com.cucumber.utility.TestUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@When("^login to ResMed application$")
	public void login_to_ResMed_application() throws Throwable 
	{
		loginPage=new LoginPage();
		homePage=loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Then("^verify title of the landing page$")
	public void verify_title_of_the_landing_page() throws Throwable 
	{
	
		boolean flag=homePage.verifyHomePage("ROS- Place Order");
		Assert.assertTrue(flag);

	}

	@Then("^logout from ResMed Application$")
	public void logout_from_resMed_application() throws Throwable
	{
		By logoutButton = By.xpath("//*[@id='myAccountForm']/a");
		TestUtil.click(logoutButton);
	}

	
}
