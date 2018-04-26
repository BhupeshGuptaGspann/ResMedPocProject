package com.cucumber.pages;

import org.openqa.selenium.By;

import com.cucumber.core.TestBase;
import com.cucumber.utility.TestUtil;

public class LoginPage extends TestBase 
{
	private By getUsername= By.xpath("//div[@class='login-center']//*[@title='Username']");
	private By getPassword=By.xpath("//div[@class='login-center']//*[@title='Password']");
	private By getloginBtn=By.xpath("//div[@class='login-center']//*[@title='LOGIN']");

	
	public HomePage signIn(String username,String password){
		TestUtil.type(getUsername, username);
		TestUtil.type(getPassword, password);
		TestUtil.click(getloginBtn);
		return new HomePage();
	}

     
}
