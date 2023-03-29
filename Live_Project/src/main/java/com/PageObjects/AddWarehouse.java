package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddWarehouse extends BaseClass{

	
	@FindBy(xpath="//a[@href='#warehouses']")
	private WebElement Warehouse_tab;
	
	@FindBy(xpath="//button[@data-target='#AddWarehouse']")
	private WebElement Add_Warehouse;
	
	@FindBy(xpath="//input[@id='WarehouseName']")
	private WebElement WarehouseName;
	
	@FindBy(xpath="//input[@id='WarehousePhone']")
	private WebElement Warehouse_Phone;
	
	@FindBy(xpath="(//input[@id='email'])[2]")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='Adresse']")
	private WebElement Address;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	private WebElement Submit_btn3;
	
	@FindBy(xpath="(//button[text()='Close'])[2]")
	private WebElement Close_btn2;
	
	
	
	public AddWarehouse() {
		
		PageFactory.initElements(getDriver(), this);
	}


	public WebElement Warehouse_tab()
	{
		return Warehouse_tab;
	}
	public WebElement add_Warehouse()
	{
		return Add_Warehouse;
	}
	public WebElement warehouseName()
	{
		return WarehouseName;
	}
	public WebElement warehouse_Phone()
	{
		return Warehouse_Phone;
	}
	public WebElement address()
	{
		return Address;
	}
	public WebElement Submit_btn3()
	{
		return Submit_btn3;
	}
	public WebElement Close_btn2()
	{
		return Close_btn2;
	}
	public WebElement email()
	{
		return email;
	}
	
}
