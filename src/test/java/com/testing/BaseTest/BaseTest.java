package com.testing.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
	
	protected WebDriver driver;
	protected DesiredCapabilities dc;
	protected URL url;
	@BeforeTest
	public void setUpDriver() throws MalformedURLException
	{
		System.out.println("Setting Up Web Driver");
		//driver = DriverFactory.openBrowser("chrome");
		String host = "localhost";
		 
		
		if(System.getProperty("BROWSER") != null && 
				System.getProperty("BROWSER").equalsIgnoreCase("chrome"))
		{
			dc = DesiredCapabilities.chrome();
		}
		else
			dc = DesiredCapabilities.firefox();
		if(System.getProperty("HUB_HOST") != null)
		{
			host = System.getProperty("HUB_HOST");
		}
		String completeURL = "http://" +host+ ":4444/wd/hub";
		url = new URL(completeURL);
		
		this.driver = new RemoteWebDriver(url,dc);
	}
	
	@AfterTest
	public void quitBrowser()
	{
		System.out.println("Closing Browser");
		driver.quit();
	}

}
