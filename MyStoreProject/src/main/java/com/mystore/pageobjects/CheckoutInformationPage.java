package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckoutInformationPage extends BaseClass
{
	@FindBy(id="first-name")
	WebElement firstName;
	@FindBy(id="last-name")
	WebElement lastName;
	@FindBy(id="postal-code")
	WebElement postalCode;
	@FindBy(id="continue")
	WebElement continueBtn;
	public CheckoutInformationPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	public void enterCheckoutInformation()
	{
		Action.type(firstName,"Abhishek");
		Action.type(lastName,"K");
		Action.type(postalCode,"560001");
	}
	public CheckoutOverviewPage clickOnContinueButton()
	{
		Action.click(getDriver(),continueBtn);
		return new CheckoutOverviewPage();
	}
}