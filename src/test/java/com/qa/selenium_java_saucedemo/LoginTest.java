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
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	
	@Test
	public void validLoginTest() {
		// TODO Auto-generated method stub
			
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			
			driver.findElement(By.id("login-button")).click(); 
			
			Assert.assertEquals(driver.findElement(By.cssSelector(".header_secondary_container .title")).getText(),"Products");
			
	}
	
	@Test
	public void invalidLoginTest() {
			
		
			driver.findElement(By.id("user-name")).sendKeys("standard_user1");
			driver.findElement(By.id("password")).sendKeys("secret_sauce122");
			
			driver.findElement(By.id("login-button")).click(); 
			
			Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");
			
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
