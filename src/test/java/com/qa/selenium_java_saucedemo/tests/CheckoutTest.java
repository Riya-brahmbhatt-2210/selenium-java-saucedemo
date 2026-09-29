package com.qa.selenium_java_saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.selenium_java_saucedemo.CartPage;
import com.qa.selenium_java_saucedemo.CheckoutPage;
import com.qa.selenium_java_saucedemo.LoginPage;
import com.qa.selenium_java_saucedemo.ProductsPage;
import com.qa.selenium_java_saucedemo.Base.BaseTest;

import testdata.TestData;

public class CheckoutTest extends BaseTest {
	
	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	


	@BeforeMethod
	public void initialize() {
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void completeEndToEndTest() {
		productsPage=loginPage.login(TestData.VALID_USERNAME,TestData.VALID_PASSWORD);
		productsPage.addProductToCart(TestData.BACKPACK);
		cartPage=productsPage.clickCartIcon();
		String cartProduct = cartPage.getProductAdded();
		Assert.assertEquals(TestData.BACKPACKNAME, cartProduct);
		checkoutPage=cartPage.clickCheckoutButton();
		checkoutPage.checkout(TestData.FIRST_NAME, TestData.LAST_NAME, TestData.POSTAL_CODE);
		Assert.assertEquals(TestData.ORDER_SUCCESS_MSG, checkoutPage.getCheckoutCompleteMessage());
		checkoutPage.clickBackToHomeButton();
	}
	
	@Test
	public void checkoutFormValidation() {
		productsPage=loginPage.login(TestData.VALID_USERNAME,TestData.VALID_PASSWORD);
		productsPage.addProductToCart(TestData.BACKPACK);
		cartPage=productsPage.clickCartIcon();
		String cartProduct = cartPage.getProductAdded();
		Assert.assertEquals(TestData.BACKPACKNAME, cartProduct);
		checkoutPage=cartPage.clickCheckoutButton();
		checkoutPage.enterFirstName(TestData.FIRST_NAME);
		checkoutPage.enterLastName(TestData.LAST_NAME);
		checkoutPage.submitCheckoutForm();
		Assert.assertEquals(TestData.POSTAL_CODE_REQ_ERROR, checkoutPage.getErrorMessage());
	}
}
