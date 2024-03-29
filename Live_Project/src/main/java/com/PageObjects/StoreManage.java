package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;

public class StoreManage extends BaseClass {
	

	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement Add_Zone;
	
	@FindBy(xpath="//input[@id='ZonesName']")
	private WebElement Add_Zone_Name;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement Add_Zone_Submit_btn;
	
	@FindBy(xpath="(//button[text()='Close'])[2]")
	private WebElement Add_Zone_Close_btn;
	
	@FindBy(xpath="//i[@class='fa fa-pencil editzone']")
	private WebElement Edit_Zone;
	
	@FindBy(xpath="//input[@id='ZoneName']")
	private WebElement Edit_Zone_Name;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	private WebElement Edit_Zone_Submit_btn;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement Edit_table_Submit_btn;
	
	
	@FindBy(xpath="(//button[text()='Close'])[3]")
	private WebElement Edit_Zone_Close_btn;
	
	@FindBy(xpath="(//i[@class='fa fa-times deletezone'])[1]")
	private WebElement Delete_Zone;
	
	@FindBy(xpath="//button[@class='confirm']")
	private WebElement Delete_Zone_confirm;
	
	@FindBy(xpath="//button[@data-target='#Addtable']")
	private WebElement Add_table;
	
	@FindBy(xpath="//input[@id='TableName']")
	private WebElement Table_Name;
	
	@FindBy(xpath="//select[@id='Zones']")
	private WebElement Choose_Zone;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	private WebElement Close_btn1;
	
	@FindBy(xpath="//h2[text()='Store Zones']")
	private WebElement Zone_heading;
	
	@FindBy(xpath="(//a[@data-original-title='Delete'])[1]")
	private WebElement Table_delete;
	
	@FindBy(xpath="(//a[@data-original-title='Edit'])[1]")
	private WebElement Table_edit;
	
	
	public StoreManage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	public WebElement Delete_Zone_confirm()
	{
		return Delete_Zone_confirm;
	}
		
	public WebElement Edit_table_Submit_btn()
	{
		return Edit_table_Submit_btn;
	}
	
	public WebElement Table_delete()
	{
		return Table_delete;
	}
	public WebElement Table_edit()
	{
		return Table_edit;
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
	public WebElement edit_Zone_Name()
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
	public WebElement Zone_heading()
	{
		return Zone_heading;
	}
	
	public void common_steps()
	{
		act.click1(hp.stores(), "Clicked");	
		Log.info("clicked  store menu");
		act.click1(sp.Manage_Table(), "Clicked manage store icon ");
		
	}
	
}
