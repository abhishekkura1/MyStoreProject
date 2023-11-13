package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckoutOverviewPage extends BaseClass
{
	@FindBy(id="finish")
	WebElement finishBtn;
	public CheckoutOverviewPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	public LogoutPage clickOnFinishButton()
	{
		Action.click(getDriver(),finishBtn);
		return new LogoutPage();
	}
}