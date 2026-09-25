package com.qa.selenium_java_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginBtn = By.id("login-button");
	private By loginError= By.cssSelector("h3[data-test='error']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(this.username).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}
	public ProductsPage clickLogin() {
		driver.findElement(loginBtn).click();
		return new ProductsPage(driver);
	}
	
	public String getLoginErrorMessage() {
		return driver.findElement(loginError).getText();
	}
}
