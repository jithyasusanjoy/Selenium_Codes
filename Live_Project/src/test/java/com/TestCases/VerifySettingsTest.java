package com.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddUser;
import com.PageObjects.AddWarehouse;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

public class VerifySettingsTest extends BaseClass {
	@BeforeTest
	public void launch()
	{
		launchApp();
		common_methods();
	}
	public void common_methods()
	{
	
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp= new HomePage(driver);
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.settings(), "Clicked settings");	
		Log.info("Clicked  settings menu");
		
	}
	
	@Test(priority=1)
	public void add_new_user() throws Exception 
	{
		Log.startTestCase("add_new_user");
		AddUser au = new AddUser(driver);
		act.click1(au.add_User(), "Clicked add user");	
		Log.info("Clicked add user button");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddUser");
		act.type(au.username(), exceldata.get(0));
		Log.info("Entered user name");
		act.type(au.firstname(), exceldata.get(1));
		Log.info("Entered first name");
		act.type(au.lastname(), exceldata.get(2));
		Log.info("Entered last name");
		act.click1(au.rbtn_sales(), "Selected sales staff");
		act.type(au.email(), exceldata.get(3));
		Log.info("Entered user email");
		act.type(au.password(), exceldata.get(4));
		Log.info("Entered password");
		act.type(au.confirm_password(), exceldata.get(5));
		Log.info("Entered confirm password");
		act.type(au.file(), exceldata.get(6));
		Log.info("Entered file");
		act.click1(au.Submit_btn(), "Submitted");
		Assert.assertTrue(au.add_User().isDisplayed());
		Log.info("User added successfully");
		Log.endTestCase("add_new_user");
		}
	@Test(priority=2)
	public void add_new_warehouse() throws Exception 
	{
		Log.startTestCase("add_new_warehouse");
		AddWarehouse aw = new AddWarehouse(driver);
		act.click1(aw.add_Warehouse(), "Clicked AddWarehouse");	
		Log.info("Clicked add Warehouse button");
		ExcelRead data1= new ExcelRead();
		ArrayList<String> exceldata1=data1.getData("AddWarehouse");
		act.type(aw.warehouseName(), exceldata1.get(0));
		Log.info("Entered warehouse name");
		act.type(aw.warehouse_Phone(), exceldata1.get(1));
		Log.info("Entered warehouse phone");
		act.type(aw.email(), exceldata1.get(2));
		Log.info("Entered email");
		act.type(aw.address(), exceldata1.get(3));
		Log.info("Entered address");
		act.click1(aw.Submit_btn3(), "Submitted");
		Assert.assertTrue(aw.add_Warehouse().isDisplayed());
		Log.info("Warehouse added successfully");
		Log.endTestCase("add_new_warehouse");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
