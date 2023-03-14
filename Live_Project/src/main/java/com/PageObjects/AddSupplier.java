package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddSupplier extends BaseClass {

	
	@FindBy(xpath="//button[@data-target='#AddSupplier']")
	WebElement Add_Supplier;
	
	@FindBy(xpath="//input[@id='SupplierName']")
	WebElement Supplier_Name;
	
	@FindBy(xpath="//input[@id='SupplierPhone']")
	WebElement Supplier_Phone;
	
	@FindBy(xpath="//input[@id='SupplierEmail']")
	WebElement Supplier_Email;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	WebElement Note;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement Close_btn1;
	
	
	public AddSupplier() {
		
		PageFactory.initElements(getDriver(), this);
	}


	public WebElement add_Supplier()
	{
		return Add_Supplier;
	}
	public WebElement supplier_Name()
	{
		return Supplier_Name;
	}
	public WebElement supplier_Phone()
	{
		return Supplier_Phone;
	}
	public WebElement supplier_Email()
	{
		return Supplier_Email;
	}
	public WebElement note()
	{
		return Note;
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
