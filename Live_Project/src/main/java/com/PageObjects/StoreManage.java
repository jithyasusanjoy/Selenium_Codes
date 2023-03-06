package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreManage {
	
WebDriver driver;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	WebElement Add_Zone;
	
	@FindBy(xpath="//input[@id='ZonesName']")
	WebElement Add_Zone_Name;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement Add_Zone_Submit_btn;
	
	@FindBy(xpath="(//button[text()='Close'])[2]")
	WebElement Add_Zone_Close_btn;
	
	@FindBy(xpath="//i[@class='fa fa-pencil editzone']")
	WebElement Edit_Zone;
	
	@FindBy(xpath="//input[@id='ZoneName']")
	WebElement Edit_Zone_Name;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	WebElement Edit_Zone_Submit_btn;
	
	@FindBy(xpath="(//button[text()='Close'])[3]")
	WebElement Edit_Zone_Close_btn;
	
	@FindBy(xpath="fa fa-times deletezone")
	WebElement Delete_Zone;
	
	@FindBy(xpath="//button[@data-target='#Addtable']")
	WebElement Add_table;
	
	@FindBy(xpath="//input[@id='TableName']")
	WebElement Table_Name;
	
	@FindBy(xpath="//select[@id='Zones']")
	WebElement Choose_Zone;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement Close_btn1;
	
	
	public StoreManage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement add_Zone()
	{
		return Add_Zone;
	}
	public WebElement add_zone_Name()
	{
		return Add_Zone_Name;
	}
	public WebElement add_Zone_Submit_btn()
	{
		return Add_Zone_Submit_btn;
	}
	public WebElement add_Zone_Close_btn()
	{
		return Add_Zone_Close_btn;
	}
	public WebElement dit_Zone_Name()
	{
		return Edit_Zone_Name;
	}
	public WebElement edit_Zone()
	{
		return Edit_Zone;
	}
	public WebElement delete_Zone()
	{
		return Delete_Zone;
	}	
	public WebElement edit_Zone_Submit_btn()
	{
		return Edit_Zone_Submit_btn;
	}
	public WebElement edit_Zone_Close_btn()
	{
		return Edit_Zone_Close_btn;
	}
	public WebElement add_table()
	{
		return Add_table;
	}
	public WebElement Table_Name()
	{
		return Table_Name;
	}
	public WebElement Choose_Zone()
	{
		return Choose_Zone;
	}
	public WebElement Submit_btn1()
	{
		return Submit_btn1;
	}
	public WebElement Close_btn1()
	{
		return Close_btn1;
	}
	
}