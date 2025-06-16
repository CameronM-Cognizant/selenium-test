package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoqa.base.Base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HomePage {
	WebDriver driver;
	
	@BeforeClass
    public void setUp() {
    	Base base = new Base();
    	WebDriver driver = base.getWebDriver();
        driver.get("https://demoqa.com/books");
    }
	
	public HomePage() {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span")
    private WebElement elementsButton;
	
	public void clickElementsButton() {
        elementsButton.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/span")
    private WebElement formsButton;
	
	public void formsButton() {
        formsButton.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/span")
    private WebElement alertsButton;
	
	public void clickAlertsButton() {
        alertsButton.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[4]/span")
    private WebElement widgetsButton;
	
	public void clickWidgetsButton() {
        widgetsButton.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[5]/span")
    private WebElement interactionsButton;
	
	public void clickInteractionsButton() {
        interactionsButton.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[6]/span")
    private WebElement bookStoreButton;
	
	public void clickBookStoreButton() {
        bookStoreButton.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"searchBox-wrapper\"]/div[1]/div")
    private WebElement bookSearch;
	
	public void useBookSearch() {
		bookSearch.sendKeys("programming");
        bookSearch.submit();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/header/a")
    private WebElement imageLink;
	
	public void clickImageLink() {
        imageLink.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/span[2]/select")
    private WebElement rowsDropDown;
	
	public void useRowsDropDown() {
		bookSearch.sendKeys("50 rows");
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[4]")
    private WebElement publisherSort;
	
	public void sortByPublisher() {
		publisherSort.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[1]")
    private WebElement imageSort;
	
	public void sortByImage() {
		imageSort.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]")
    private WebElement titleSort;
	
	public void sortByTitle() {
		titleSort.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[3]")
    private WebElement authorSort;
	
	public void sortByAuthor() {
		authorSort.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginButton;
	
	public void clickLoginButton() {
		loginButton.click();
    }
	
	
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}