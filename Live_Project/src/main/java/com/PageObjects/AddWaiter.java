package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddWaiter extends BaseClass{

	
	@FindBy(xpath="//button[@data-target='#AddWaiter']")
	private WebElement Add_Waiter;
	
	@FindBy(xpath="//input[@id='WaiterName']")
	private WebElement Waiter_Name;
	
	@FindBy(xpath="//input[@id='WaiterPhone']")
	private WebElement Waiter_Phone;
	
	@FindBy(xpath="//input[@id='WaiterEmail']")
	private WebElement Waiter_Email;
	
	@FindBy(xpath="//select[@id='WaiterStore']")
	private WebElement Waiter_Store;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement Close_btn1;
	
	
	public AddWaiter() {
	
		PageFactory.initElements(getDriver(), this);
	}


	public WebElement add_Waiter()
	{
		return Add_Waiter;
	}
	public WebElement waiter_Name()
	{
		return Waiter_Name;
	}
	public WebElement waiter_Phone()
	{
		return Waiter_Phone;
	}
	public WebElement waiter_Email()
	{
		return Waiter_Email;
	}
	public WebElement waiter_Store()
	{
		return Waiter_Store;
	}
	public WebElement Submit_btn()
	{
		return Submit_btn1;
	}
	public WebElement Close_btn()
	{
		return Close_btn1;
	}
	
}
