package com.qa.selenium_java_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By postalCodeInput = By.id("postal-code");
	
	private By continueButton = By.id("continue");
	private By finishButton = By.id("finish");
	
	private By checkoutCompleteMessage = By.cssSelector(".complete-header");
	
	private By backToHomeButton = By.id("back-to-products");
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameInput).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}
	
	
	public void enterPostalCode(String postalCode) {
		driver.findElement(postalCodeInput).sendKeys(postalCode);
	}
	
	public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
	}
	
	public void submitCheckoutForm() {
		driver.findElement(continueButton).click();
	}
	
	public void completeCheckoutForm() {
		driver.findElement(finishButton).click();
	}
	
	public String getCheckoutCompleteMessage() {
		return driver.findElement(checkoutCompleteMessage).getText();
	}
	
	public void checkout(String firstName, String lastName, String postalCode) {
		fillCheckoutForm(firstName, lastName, postalCode);
		submitCheckoutForm();	
		completeCheckoutForm();
	}
	
	public ProductsPage clickBackToHomeButton() {
		driver.findElement(backToHomeButton).click();
		return new ProductsPage(driver);
	}

}
