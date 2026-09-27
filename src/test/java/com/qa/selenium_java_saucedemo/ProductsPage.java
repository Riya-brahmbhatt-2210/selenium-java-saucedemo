package com.qa.selenium_java_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	
	private WebDriver driver;

	private By pageTitle = By.cssSelector(".header_secondary_container .title");
	
	private By cartIcon = By.id("shopping_cart_container");
	
	private String productid = "add-to-cart-";
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
	public void addProductToCart(String productIdSlug) {
		 driver.findElement(By.id(productid+productIdSlug)).click();
	}
	
	public CartPage clickCartIcon() {
		driver.findElement(cartIcon).click();
		return new CartPage(driver);
	}
	
}
