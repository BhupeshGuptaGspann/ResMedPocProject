package com.cucumber.core;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumber.utility.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
		try{
			FileInputStream configFile=new FileInputStream
					(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cucumber\\resources\\Config.properties");
			prop.load(configFile);
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
					"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("FF") || browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("ie") || browserName.equalsIgnoreCase("internet explorer")){
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			//driver.get("https://www.google.com");
/*			DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
	        capab.setCapability(
	            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	            true);

	        driver = new InternetExplorerDriver(capab);*/
		}
		
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICTI_WAIT, TimeUnit.SECONDS);
//		driver.get(prop.getProperty("BaseURL"));
		
	}


}
