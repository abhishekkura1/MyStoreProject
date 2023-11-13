package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass
{
	@FindBy(id="user-name")
	WebElement logInUserName;
	@FindBy(id="password")
	WebElement logInPassword;
	@FindBy(id="login-button")
	WebElement logInBtn;
	public LoginPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	public HomePage login(String uname,String pwd)
	{
		Action.type(logInUserName,uname);
		Action.type(logInPassword,pwd);
		Action.click(getDriver(),logInBtn);
		return new HomePage();
	}
	public String getMyStoreTitle()
	{
		String myStoreTitle=getDriver().getTitle();
		return myStoreTitle;
	}
}