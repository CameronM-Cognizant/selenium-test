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
import com.demoqa.utilities.ExcelDataProvider;
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
		boolean isVisible = homePage.isNavListVisible();
		try {
			assertTrue(isVisible, "Opening elements navbar list");
		}
		finally {
			log.info("Completed test: testElementsListCollapsible");
			log.info("Elements list is visible: " + isVisible);
		}
	}


	@Test
	public void testEmptyUserNameField() {
		log.info("Starting test: testEmptyUserNameField");
		log.info("Navigating to Login page");
		driver.get("https://demoqa.com/login");
		loginPage = new LoginPage(driver);
		boolean isValid = loginPage.isUserNameValid("");
		try {
			assertTrue(isValid, "Attempting to login without credentials");
		}
		finally {
			log.info("Completed test: testEmptyUserNameField");
			log.info("Login accepts empty UserName: " + isValid);
		}
	}


	@Test
	public void testValidLogin() {
		log.info("Starting test: testValidLogin");
		log.info("Navigating to Login page");
		driver.get("https://demoqa.com/login");
		loginPage = new LoginPage(driver);
		loginPage.login("testUser0", "testPassword0!");

		boolean isValid = driver.getCurrentUrl().equals("https://demoqa.com/profile");
		try {
			assertTrue(isValid, "Attempting to login with valid credentials");
		}
		finally {
			log.info("Completed test: testValidLogin");
			log.info("Login accepts valid credentials: " + isValid);
		}
	}


	@Test
	public void testDBConnection() {
		log.info("Starting test: testDBConnection");
		log.info("Connecting to database");
		DatabaseUtil.connect();
		boolean isValid = DatabaseUtil.getFirstBookTitle();
		try {
			assertTrue(isValid, "Attempting to collect first book title from database");
		}
		finally {
			log.info("Completed test: testDBConnection");
			log.info("First book received: " + isValid);
		}
	}


	@Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
	public void testLoginFromExcel(String username, String password) {
		log.info("Starting test: testLoginFromExcel");
		log.info("Navigating to Login page");
		driver.get("https://demoqa.com/login");
		loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		boolean isValid = driver.getCurrentUrl().equals("https://demoqa.com/profile");
		try {
			assertTrue(isValid, "Attempting to login with Excel Data");
		}
		finally {
			log.info("Completed test: testLoginFromExcel using username='" + username + "' password='" + password + "'");
			log.info("Login accepts the Excel data: " + isValid);
		}
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Shutting down driver\n");
	}	
}
