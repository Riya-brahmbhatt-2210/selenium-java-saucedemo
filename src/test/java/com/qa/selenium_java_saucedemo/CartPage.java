package com.qa.selenium_java_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	private WebDriver driver;
	
	private By checkoutButton = By.id("checkout");
	
	private By productName =By.className("inventory_item_name");
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public CheckoutPage clickCheckoutButton() {
		driver.findElement(checkoutButton).click();
		return new CheckoutPage(driver);
	}
	
	public String getProductAdded() {
		System.out.println("Cart URL: " + driver.getCurrentUrl());
		return driver.findElement(productName).getText();
	}
	
	
	
	
}
