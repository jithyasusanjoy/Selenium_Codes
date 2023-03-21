package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddUser extends BaseClass {

	
	@FindBy(xpath="//a[@href='#users']")
	private WebElement User_tab;
	
	@FindBy(xpath="//button[@data-target='#AddUser']")
	private WebElement Add_User;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement Username;
	
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='confirm_password']")
	private WebElement confirm_password;
	
	@FindBy(xpath="//input[@value='admin']")
	private WebElement rbtn_admin;
	
	@FindBy(xpath="//input[@value='sales']")
	private WebElement rbtn_sales;
	
	@FindBy(xpath="//input[@value='waiter']")
	private WebElement rbtn_waiter;
	
	@FindBy(xpath="//input[@value='kitchen']")
	private WebElement rbtn_kitchen;
	
	@FindBy(xpath="//input[@id='Avatar']")
	private WebElement file;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement Submit_btn2;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement Close_btn1;
	

	
	public AddUser() {
		
		PageFactory.initElements(getDriver(), this);
	}


	public WebElement user_tab()
	{
		return User_tab;
	}
	public WebElement add_User()
	{
		return Add_User;
	}
	public WebElement username()
	{
		return Username;
	}
	public WebElement firstname()
	{
		return firstname;
	}
	public WebElement lastname()
	{
		return lastname;
	}
	public WebElement Submit_btn()
	{
		return Submit_btn2;
	}
	public WebElement Close_btn()
	{
		return Close_btn1;
	}
	public WebElement email()
	{
		return email;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement confirm_password()
	{
		return confirm_password;
	}
	public WebElement rbtn_kitchen()
	{
		return rbtn_kitchen;
	}
	public WebElement rbtn_waiter()
	{
		return rbtn_waiter;
	}
	public WebElement rbtn_sales()
	{
		return rbtn_sales;
	}
	public WebElement rbtn_admin()
	{
		return rbtn_admin;
	}
	
	public WebElement file()
	{
		return file;
	}
	
}
