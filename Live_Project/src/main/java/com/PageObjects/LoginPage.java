package com.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.BaseClass.BaseClass;

public class LoginPage extends BaseClass {


	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement login;
	
	@FindBy(xpath="//h1[text()='Login']")
	private WebElement login_label;
	
	@FindBy(xpath="//img[@alt='logo']")
	private WebElement logo;
	
	
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
		wait.explicitWait_elementVisibility(getDriver(), login_label, Duration.ofSeconds(10));
		return login_label;
	}
	public Boolean IsLogoPresent() {
		
		return act.isDisplayed(getDriver(), logo);
	}
	public void LoginFn()
	{
		act.type(username,prop.getProperty("Username"));
		act.type(password,prop.getProperty("Password"));
		act.click1(login,"Clicking On Login Button");
	}
	
	
}
