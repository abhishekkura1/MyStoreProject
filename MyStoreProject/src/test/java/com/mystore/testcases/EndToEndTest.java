package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.CheckoutInformationPage;
import com.mystore.pageobjects.CheckoutOverviewPage;
import com.mystore.pageobjects.CheckoutPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.LogoutPage;

public class EndToEndTest extends BaseClass
{
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	CheckoutInformationPage checkoutInformationPage;
	CheckoutOverviewPage checkoutOverviewPage;
	LogoutPage logoutPage;
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
	public void endToEndTest()throws InterruptedException
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		addToCartPage=homePage.clickOnProduct();
		addToCartPage.clickOnAddToCartButton();
		checkoutPage=addToCartPage.clickOnShoppingCartLink();
		checkoutInformationPage=checkoutPage.clickOnCheckoutButton();
		checkoutInformationPage.enterCheckoutInformation();
		checkoutOverviewPage=checkoutInformationPage.clickOnContinueButton();
		logoutPage=checkoutOverviewPage.clickOnFinishButton();
		String actualMessage=logoutPage.validateConfirmationMessage();
		String expectedMessage="Thank you for your order!";
		Assert.assertEquals(actualMessage,expectedMessage);
		logoutPage.clickOnLogout();
	}
}