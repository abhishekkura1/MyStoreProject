package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckoutPage extends BaseClass
{
	@FindBy(xpath="//div[@class='inventory_item_price']")
	WebElement priceTxt;
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	public CheckoutPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	public double getPrice()
	{
		String price=priceTxt.getText();
		String unit=price.replaceAll("[^a-zA-Z0-9]","");
		double finalPrice=Double.parseDouble(unit);
		return finalPrice/100;
	}
	public CheckoutInformationPage clickOnCheckoutButton()
	{
		Action.click(getDriver(),checkoutBtn);
		return new CheckoutInformationPage();
	}
}