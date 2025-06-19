package com.demoqa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.demoqa.utilities.PropertiesHandler;


public class Base {
	protected static WebDriver driver;
	public WebDriver getWebDriver() {
		PropertiesHandler config = new PropertiesHandler();
		
		try {
			switch (config.getProperty("browser")) {
			case "chrome":
				driver = new ChromeDriver();
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				break;
				
			case "safari":
				driver = new SafariDriver();
				break;
				
			case "internet explorer":
				driver = new InternetExplorerDriver();
				break;
				
			default:
				driver = new ChromeDriver();
				break;
			}
		}
		catch (Exception e) {
			System.out.println("problem initialising driver");
			driver = null;
		}
		
		return driver;
	}
}

