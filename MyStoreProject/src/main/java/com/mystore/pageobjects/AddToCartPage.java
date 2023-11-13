package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass
{
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement addToCartBtn;
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement shoppingCartLink;
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	public boolean validateAddToCart()
	{
		return Action.isDisplayed(getDriver(),addToCartBtn);
	}
	public void clickOnAddToCartButton()
	{
		Action.click(getDriver(),addToCartBtn);
	}
	public CheckoutPage clickOnShoppingCartLink()
	{
		Action.click(getDriver(),shoppingCartLink);
		return new CheckoutPage();
	}
}