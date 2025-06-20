package com.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	Actions action;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
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
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/header/a")
    private WebElement imageLink;
	
	public void clickImageLink() {
        imageLink.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginButton;
	
	public void clickLoginButton() {
		action.moveToElement(loginButton);
		loginButton.click();
    }
	
	
	@FindBy(xpath = "//*[@id=\"userName\"]")
    private WebElement userNameField;
	
	public boolean isUserNameValid(String name) {
		userNameField.sendKeys(name);
		clickLoginButton();
		return !userNameField.getAttribute("class").contains("is-invalid");
	}
	
	@FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passWordField;
	
	public void login(String name, String pass) {		
		userNameField.sendKeys(name);
		passWordField.sendKeys(pass);
		clickLoginButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void adRemoval() {
		JavascriptExecutor js = null;
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor) driver;
		}
		js.executeScript("return document.getElementById('RightSide_Advertisement').remove();");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
