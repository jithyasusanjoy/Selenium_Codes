package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddStorePage extends BaseClass{

	
	@FindBy(xpath="//input[@id='StoreName']")
	WebElement StoreName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='StorePhone']")
	WebElement StorePhone;
	
	@FindBy(xpath="//input[@id='Country']")
	WebElement Country;
	
	@FindBy(xpath="//input[@id='City']")
	WebElement City;
	
	@FindBy(xpath="//input[@id='Adresse']")
	WebElement Address;
	
	@FindBy(xpath="//input[@id='CustomeFooter']")
	WebElement CustomerFooter;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit_btn;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement Close_btn;
	
	

	public AddStorePage() {
	
		PageFactory.initElements(getDriver(), this);
	}


	public WebElement storename()
	{
		return StoreName;
	}
	public WebElement email()
	{
		return Email;
	}
	public WebElement storephone()
	{
		return StorePhone;
	}
	public WebElement country()
	{
		return Country;
	}
	
	public WebElement city()
	{
		return City;
	}
	public WebElement address()
	{
		return Address;
	}
	public WebElement customerfooter()
	{
		return CustomerFooter;
	}
	public WebElement Submit_btn()
	{
		return Submit_btn;
	}
	public WebElement Close_btn()
	{
		return Close_btn;
	}
	public void fluentwait(WebElement element, int i)
	{
		act.fluentWait(getDriver(), element,i);
	}
}
