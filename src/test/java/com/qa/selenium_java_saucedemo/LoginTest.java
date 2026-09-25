package com.qa.selenium_java_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
	}

	@Test
	public void validLoginTest() {
		// TODO Auto-generated method stub

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		Assert.assertEquals(driver.findElement(By.cssSelector(".header_secondary_container .title")).getText(),
				"Products");

	}

	@Test
	public void invalidLoginTest() {

		loginPage.enterUsername("standard_user1");
		loginPage.enterPassword("secret_sauce222");
		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getLoginErrorMessage(),
				"Epic sadface: Username and password do not match any user in this service");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
