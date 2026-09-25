package com.qa.selenium_java_saucedemo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	ProductsPage productsPage;
	
	@BeforeMethod
	public void initialize() {
		loginPage = new LoginPage(driver);
	}

	@Test
	public void validLoginTest() {

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		productsPage=loginPage.clickLogin();

		Assert.assertEquals(productsPage.getPageTitle(),
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

	
}
