package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddExpense extends BaseClass{

	@FindBy(xpath="//button[@data-target='#AddExpence']")
	private WebElement Add_Expense;
	
	@FindBy(xpath="//input[@id='Date']")
	private WebElement Date;
	
	@FindBy(xpath="//input[@id='Reference']")
	private WebElement Reference;
	
	@FindBy(xpath="//input[@id='Amount']")
	private WebElement Amount;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement Note;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement Close_btn1;
	
	@FindBy(xpath="//select[@id='Category']")
	private WebElement Category;
	
	@FindBy(xpath="//select[@id='store_id']")
	private WebElement Store;
	
	@FindBy(xpath="//input[@id='attachment']")
	private WebElement Attachment;
	
	
	
	
	public AddExpense() {
		
		PageFactory.initElements(getDriver(), this);
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
