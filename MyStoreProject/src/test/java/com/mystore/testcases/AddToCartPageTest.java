package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;

public class AddToCartPageTest extends BaseClass
{
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
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
	@Test(groups={"Regression","Sanity"})
	public void addToCartTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		addToCartPage=homePage.clickOnProduct();
		boolean result=addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
	}
}