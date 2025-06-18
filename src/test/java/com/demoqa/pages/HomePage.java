package com.demoqa.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import org.testng.annotations.AfterClass;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
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
	
	public void useBookSearch(String send) {
		bookSearch.sendKeys(send);
        bookSearch.submit();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/header/a")
    private WebElement imageLink;
	
	public void clickImageLink() {
        imageLink.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/span[2]/select")
    private WebElement rowsDropDown;
	
	public void useRowsDropDown(String rows) {
		rowsDropDown.sendKeys(rows);
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
	
	public LoginPage clickLoginButton() {
		loginButton.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
    }
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/div")
    private WebElement elementsList;
	
	public boolean isNavListVisible() {
		return elementsList.isDisplayed();
	}
}