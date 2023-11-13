package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.CheckoutPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;

public class CheckoutPageTest extends BaseClass
{
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	@Parameters("browser")
	@BeforeMethod(groups={"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	@AfterMethod(groups={"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	@Test(groups="Regression")
	public void verifyPrice()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		addToCartPage=homePage.clickOnProduct();
		addToCartPage.clickOnAddToCartButton();
		checkoutPage=addToCartPage.clickOnShoppingCartLink();
		double expectedPrice=checkoutPage.getPrice();
		Assert.assertEquals(9.99,expectedPrice);
	}
}