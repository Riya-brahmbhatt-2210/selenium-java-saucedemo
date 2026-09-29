package com.qa.selenium_java_saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium_java_saucedemo.CartPage;
import com.qa.selenium_java_saucedemo.LoginPage;
import com.qa.selenium_java_saucedemo.ProductsPage;
import com.qa.selenium_java_saucedemo.Base.BaseTest;

import testdata.TestData;

public class ProductTest extends BaseTest{
	
	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	
	
	@BeforeMethod
	public void initialize() {
		loginPage = new LoginPage(driver);
	}

	@Test
	public void verifyBackpackAddedToCart() {
		productsPage=loginPage.login(TestData.VALID_USERNAME,TestData.VALID_PASSWORD);
		productsPage.addProductToCart(TestData.BACKPACK);
		cartPage=productsPage.clickCartIcon();
		String cartProduct = cartPage.getProductAdded();
		Assert.assertEquals(TestData.BACKPACKNAME, cartProduct);
	}
	
	@Test
	public void verifyRemovingBackpackFromCart() {
		productsPage=loginPage.login(TestData.VALID_USERNAME,TestData.VALID_PASSWORD);
		productsPage.removeProductFromCart(TestData.BACKPACK);
	}
}
