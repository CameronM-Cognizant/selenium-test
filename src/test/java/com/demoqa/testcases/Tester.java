package com.demoqa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoqa.base.Base;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.utilities.DatabaseUtil;
import com.demoqa.utilities.TestListener;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(TestListener.class)
public class Tester extends Base {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private static final Logger log = LogManager.getLogger(Tester.class);
	
	@BeforeMethod
	public void initTest() {
		Base base = new Base();
		driver = base.getWebDriver();
	}
	
	
	@Test
	public void testElementsListCollapsible() {
		log.info("Starting test: testElementsListCollapsible");
		log.info("Navigating to Books page");
		driver.get("https://demoqa.com/books");
		homePage = new HomePage(driver);
		log.info("Clicking on 'Elements' button on homepage");
		homePage.clickElementsButton();
		Boolean isVisible = homePage.isNavListVisible();
		assertTrue(isVisible, "Opening elements navbar list");
		log.info("Completed test: testElementsListCollapsible");
		log.info("Elements list is visible: " + isVisible);
	}
	
	
	@Test
	public void testEmptyUserNameField() {
		log.info("Starting test: testEmptyUserNameField");
		log.info("Navigating to Login page");
		driver.get("https://demoqa.com/login");
		loginPage = new LoginPage(driver);
		Boolean isValid = loginPage.isUserNameValid("");
		assertTrue(isValid, "Attempting to login without credentials");
		log.info("Completed test: testEmptyUserNameField");
		log.info("Login accepts empty UserName: " + isValid);
	}
	
	
	@Test
	public void testDBConnection() {
		log.info("Starting test: testDBConnection");
		log.info("Connecting to database");
		DatabaseUtil.connect();
		Boolean isValid = DatabaseUtil.getFirstBookTitle();
		assertTrue(isValid, "Attempting to collect first book title from database");
		log.info("Completed test: testDBConnection");
		log.info("First book received: " + isValid);
	}
	

	@AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("Shutting down driver\n");
    }	
}
