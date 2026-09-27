package com.qa.selenium_java_saucedemo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{
	
	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	
	String product="sauce-labs-Backpack";
	
	@BeforeMethod
	public void initialize() {
		loginPage = new LoginPage(driver);
	}

	@Test
	public void verifyBackpackAddedToCart() {
		productsPage=loginPage.login("standard_user1","secret_sauce222");
		productsPage.addProductToCart(product);
		cartPage=productsPage.clickCartIcon();
		String cartProduct = cartPage.getProductAdded();
		Assert.assertEquals(product.replace("-", " "), cartProduct);
	}
}
