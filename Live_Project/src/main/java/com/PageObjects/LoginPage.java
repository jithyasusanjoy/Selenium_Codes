package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.BaseClass.BaseClass;

public class LoginPage extends BaseClass {


	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement login;
	
	@FindBy(xpath="//h1[text()='Login']")
	WebElement login_label;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logo;
	
	
	public LoginPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	public WebElement uname()
	{
		return username;
	}
	public WebElement pwd()
	{
		return password;
	}
	public WebElement lbutton()
	{
		return login;
	}
	public WebElement login_label()
	{
		return login_label;
	}
	public Boolean IsLogoPresent() {
		//return DispLogo().isDisplayed();
		return act.isDisplayed(getDriver(), logo);
	}
	public void LoginFn()
	{
		act.type(username,prop.getProperty("Username"));
		act.type(password,prop.getProperty("Password"));
		act.click1(login,"Clicking On Login Button");
	}
	
}
