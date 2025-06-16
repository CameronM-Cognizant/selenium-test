package com.demoqa.pages;

import org.openqa.selenium.WebDriver;

import com.demoqa.base.Base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HomePage {
	private WebDriver driver;
	
	@BeforeClass
    public void setUp() {
    	Base base = new Base();
    	WebDriver driver = base.getWebDriver();
        driver.get("https://demoqa.com/books");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}