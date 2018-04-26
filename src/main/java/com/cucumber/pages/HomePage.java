package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.cucumber.core.TestBase;
import com.cucumber.utility.TestUtil;

public class HomePage extends TestBase {
	
	//private By getVerifyText=By.xpath("//h1[text()='Security Question']");
	
	@SuppressWarnings("finally")
	public boolean verifyHomePage(String value){
		try {
			TestUtil.handleAlert();
		}
		catch (NoAlertPresentException Ex) {
			System.out.println("No Alert appeared");
		}
		finally {
		return TestUtil.textEqual(TestUtil.getTitle(), value);
	}

}
}
