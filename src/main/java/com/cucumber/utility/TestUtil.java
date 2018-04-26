package com.cucumber.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.core.TestBase;



public class TestUtil extends TestBase {
	
	private final static Logger log = LogManager.getLogger(TestUtil.class); 
	public static long PAGE_LOAD_TIME=50;
	public static long IMPLICTI_WAIT=50;
	public static WebDriverWait wait;

	
	public static void type(By loc,String value)
	{
		log.info("Waiting for element: "+loc);
		WebElement element=waitForElementPresent(loc);
		log.info("element found: "+loc);
		element.sendKeys(value);
		log.info("Typing '" +value+"' into "+loc);
	}

	public static void click(By loc)
	{
		log.info("Waiting for element: "+loc);
		WebElement element=waitForElementPresent(loc);
		log.info("element found: "+loc);
		element.click();
	}
	
	public static boolean textEqualTo(By loc,String value){
		return	waitForElementPresent(loc).getText().equals(value);
		}
	
	public static boolean textEqual(String value1,String value2){
		return	value1.equals(value2);
		}
	
	public static String getTitle()
	{
		return driver.getTitle();
	}
	
	public static WebElement waitForElementPresent(By loc)
	{
		wait=new WebDriverWait(driver, PAGE_LOAD_TIME);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
	
	public static boolean isElementPresent(By loc)
	{
		WebElement element=waitForElementPresent(loc);
		return element.isDisplayed();
	}
	
	public static List<String> getList(By loc)
	{
		List<WebElement> elements= driver.findElements(loc);
		List<String> list=new ArrayList<String>();
		for(WebElement element:elements)
		{
			list.add(element.getText());
		}
		return list;
	
	}
	
	public static void getSelect(By loc,String value)
	{
		WebElement element=waitForElementPresent(loc);
		Select dropDown=new Select(element);
		dropDown.selectByVisibleText(value);
	}
	
	public static String takeScreenshotAtEndOfTest() throws IOException {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File destinationFile=new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(srcFile,destinationFile );;
		return destinationFile.toString();
	}
	
	public static void handleAlert()
	{
		driver.switchTo().alert().accept();
	}

}
