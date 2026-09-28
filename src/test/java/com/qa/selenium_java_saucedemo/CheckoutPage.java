package com.qa.selenium_java_saucedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		System.out.println("About to fill checkout form");
		System.out.println("Current URL: " + driver.getCurrentUrl());
		driver.findElement(firstNameInput).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}
	
	
	public void enterPostalCode(String postalCode) {
		driver.findElement(postalCodeInput).sendKeys(postalCode);
	}
	
	public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
		System.out.println("Checkout URL: " + driver.getCurrentUrl());
		System.out.println("Checkout title: " + driver.getTitle());
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
	}
	
	public void submitCheckoutForm() {
		 driver.findElement(continueButton).click();

		    System.out.println("After Continue URL: " + driver.getCurrentUrl());
		    System.out.println("Page source contains finish: " + driver.getPageSource().contains("finish"));

	}
	
	public void completeCheckoutForm() {

		WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(finishButton));
		driver.findElement(finishButton).click();
	}
	
	public String getCheckoutCompleteMessage() {
		return driver.findElement(checkoutCompleteMessage).getText();
	}
	
	public void checkout(String firstName, String lastName, String postalCode) {
		fillCheckoutForm(firstName, lastName, postalCode);
		submitCheckoutForm();	
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Current title: " + driver.getTitle());
		System.out.println("Page source contains finish: " + driver.getPageSource().contains("finish"));
		completeCheckoutForm();
	}
	
	public ProductsPage clickBackToHomeButton() {
		driver.findElement(backToHomeButton).click();
		return new ProductsPage(driver);
	}

}
