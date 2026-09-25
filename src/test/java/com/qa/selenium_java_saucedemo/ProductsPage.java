package com.qa.selenium_java_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	
	private WebDriver driver;

	private By pageTitle = By.cssSelector(".header_secondary_container .title");
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}

	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
}
