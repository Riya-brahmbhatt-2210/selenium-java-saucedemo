package com.qa.selenium_java_saucedemo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
	
	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	

	String product="sauce-labs-backpack";

	@BeforeMethod
	public void initialize() {
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void completeEndToEndTest() {
		productsPage=loginPage.login("standard_user","secret_sauce");
		productsPage.addProductToCart(product);
		cartPage=productsPage.clickCartIcon();
		String cartProduct = cartPage.getProductAdded();
		Assert.assertEquals("Sauce Labs Backpack", cartProduct);
		checkoutPage=cartPage.clickCheckoutButton();
		checkoutPage.checkout("fname", "lname", "H6K3J5");
		Assert.assertEquals("Thank you for your order!", checkoutPage.getCheckoutCompleteMessage());
		checkoutPage.clickBackToHomeButton();
	}
}
