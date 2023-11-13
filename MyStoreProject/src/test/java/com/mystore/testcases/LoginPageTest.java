package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass
{
	LoginPage loginPage;
	HomePage homePage;
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
	@Test(groups="Smoke")
	public void verifyTitle()
	{
		loginPage=new LoginPage();
		String actualTitle=loginPage.getMyStoreTitle();
		Assert.assertEquals(actualTitle,"Swag Labs");
	}
	@Test(dataProvider="credentials",dataProviderClass=DataProviders.class,groups={"Sanity","Smoke"})
	public void loginTest(String uname,String pswd)
	{
		Log.startTestCase("loginTest");
		loginPage=new LoginPage();
		Log.info("Enter Username and Password");
		homePage=loginPage.login(uname,pswd);
		String actualURL=homePage.getCurrURL();
		String expectedURL="https://www.saucedemo.com/inventory.html";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL,expectedURL);
		Log.info("Login is Success");
		Log.endTestCase("loginTest");
	}
}