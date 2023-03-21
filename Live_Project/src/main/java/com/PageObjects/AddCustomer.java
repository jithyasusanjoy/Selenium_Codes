package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddCustomer extends BaseClass {

	
	@FindBy(xpath="//button[@data-target='#AddCustomer']")
	private WebElement Add_Customer;
	
	@FindBy(xpath="//input[@id='CustomerName']")
	private WebElement Customer_Name;
	
	@FindBy(xpath="//input[@id='CustomerPhone']")
	private WebElement Customer_Phone;
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	private WebElement Customer_Email;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	private WebElement Customer_Discount;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement Close_btn1;
	
	
	public AddCustomer() {
		PageFactory.initElements(getDriver(), this);
	}


	public WebElement add_Customer()
	{
		return Add_Customer;
	}
	public WebElement customer_Name()
	{
		return Customer_Name;
	}
	public WebElement customer_Phone()
	{
		return Customer_Phone;
	}
	public WebElement customer_Email()
	{
		return Customer_Email;
	}
	public WebElement customer_Discount()
	{
		return Customer_Discount;
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
