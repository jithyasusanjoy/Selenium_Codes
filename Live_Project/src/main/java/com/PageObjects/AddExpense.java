package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddExpense{
WebDriver driver;
	
	@FindBy(xpath="//button[@data-target='#AddExpence']")
	WebElement Add_Expense;
	
	@FindBy(xpath="//input[@id='Date']")
	WebElement Date;
	
	@FindBy(xpath="//input[@id='Reference']")
	WebElement Reference;
	
	@FindBy(xpath="//input[@id='Amount']")
	WebElement Amount;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	WebElement Note;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement Close_btn1;
	
	@FindBy(xpath="//select[@id='Category']")
	WebElement Category;
	
	@FindBy(xpath="//select[@id='store_id']")
	WebElement Store;
	
	@FindBy(xpath="//input[@id='attachment']")
	WebElement Attachment;
	
	
	
	
	public AddExpense(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement add_Expense()
	{
		return Add_Expense;
	}
	public WebElement Date()
	{
		return Date;
	}
	public WebElement reference()
	{
		return Reference;
	}
	public WebElement amount()
	{
		return Amount;
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
	public WebElement category()
	{
		return Category;
	}
	public WebElement store()
	{
		return Store;
	}
	public WebElement attachment()
	{
		return Attachment;
	}
}
