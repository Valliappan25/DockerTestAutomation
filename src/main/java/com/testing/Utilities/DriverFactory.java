package com.testing.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
	
	public static WebDriver openBrowser(String browserType)
	{
		if(browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/n1502752/Downloads/chromedriver_linux64/chromedriver");
	        return new ChromeDriver();
		}
		else 		{
			System.setProperty("webdriver.gecko.driver","/home/n1502752/eclipse-workspace/selenium/src/driver/geckodriver");
	        return new FirefoxDriver();
		}
		
	}

}
