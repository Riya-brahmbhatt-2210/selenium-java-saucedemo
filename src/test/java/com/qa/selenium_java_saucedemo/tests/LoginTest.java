package com.qa.selenium_java_saucedemo.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium_java_saucedemo.LoginPage;
import com.qa.selenium_java_saucedemo.ProductsPage;
import com.qa.selenium_java_saucedemo.Base.BaseTest;

import testdata.TestData;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	ProductsPage productsPage;
	
	@BeforeMethod
	public void initialize() {
		loginPage = new LoginPage(driver);
	}

	@Test
	public void validLoginTest() {

		loginPage.enterUsername(TestData.VALID_USERNAME);
		loginPage.enterPassword(TestData.VALID_PASSWORD);
		productsPage=loginPage.clickLogin();

		Assert.assertEquals(productsPage.getPageTitle(),
				"Products");

	}
	

	@Test
	public void invalidLoginTest() {

		loginPage.enterUsername(TestData.INVALID_USERNAME);
		loginPage.enterPassword(TestData.INVALID_PASSWORD);
		loginPage.clickLogin();
		Assert.assertEquals(loginPage.getLoginErrorMessage(),TestData.INVALID_LOGIN_ERROR);

	}

	
}
