package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy(xpath="//span[text()='Products']")
	WebElement products;
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
	WebElement bikeLight;
	public HomePage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	public String getCurrURL()
	{
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
	public boolean validateProducts()
	{
		return Action.isDisplayed(getDriver(),products);
	}
	public AddToCartPage clickOnProduct()
	{
		Action.click(getDriver(),bikeLight);
		return new AddToCartPage();
	}
}