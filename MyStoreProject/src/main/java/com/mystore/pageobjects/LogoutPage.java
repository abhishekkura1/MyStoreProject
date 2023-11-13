package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LogoutPage extends BaseClass
{
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	WebElement confirmationMsg;
	@FindBy(id="react-burger-menu-btn")
	WebElement burgerMenu;
	@FindBy(id="logout_sidebar_link")
	WebElement logoutBtn;
	public LogoutPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	public String validateConfirmationMessage()
	{
		String confirmationMessage=confirmationMsg.getText();
		return confirmationMessage;
	}
	public void clickOnLogout()throws InterruptedException
	{
		Action.click(getDriver(),burgerMenu);
		Thread.sleep(1000);
		Action.click(getDriver(),logoutBtn);
	}
}