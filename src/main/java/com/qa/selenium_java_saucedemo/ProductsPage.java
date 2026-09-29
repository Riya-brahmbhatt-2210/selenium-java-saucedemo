package com.qa.selenium_java_saucedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	
	private WebDriver driver;

	private By pageTitle = By.cssSelector(".header_secondary_container .title");
	
	private By cartIcon = By.id("shopping_cart_container");
	
	private By btnInventory = By.className("btn_inventory");
	
	private String addToCartStr = "add-to-cart-";
	
	private String removeFromCartStr = "remove-";
	
	
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
	public void addProductToCart(String productIdSlug) {
		WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(btnInventory));
		
		if(driver.findElement(btnInventory).getText().equalsIgnoreCase("Remove")) {
			driver.findElement(By.id(removeFromCartStr+productIdSlug)).click();
		}
		driver.findElement(By.id(addToCartStr+productIdSlug)).click();
	}
	
	public void removeProductFromCart(String productIdSlug) {
		WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(btnInventory));
		
		if(driver.findElement(btnInventory).getText().equalsIgnoreCase("Add to cart")) {
			driver.findElement(By.id(addToCartStr+productIdSlug)).click();
		}
		driver.findElement(By.id(removeFromCartStr+productIdSlug)).click();
	}
	
	public CartPage clickCartIcon() {
		driver.findElement(cartIcon).click();
		return new CartPage(driver);
	}
	
}
