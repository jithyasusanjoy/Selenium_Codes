package com.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;

public class VerifySettingsTest extends BaseClass {
	
	
	@Test(priority=1,groups = { "Regression" })
	public void verify_add_new_user() throws Exception 
	{
		Log.startTestCase("add_new_user");
		lp.LoginFn();
		act.click1(hp.settings(), "Clicked  settings menu");
		act.click1(au.user_tab(), "Clicked  user tab");	
		act.click1(au.add_User(), "Clicked add user");	
		Log.info("Clicked add user button");
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
		act.type(au.file(), "C:\\Users\\jithya susan\\git\\Selenium_Codes\\Live_Project\\ExcelFile\\a2.png");
		Log.info("Entered file");
		act.click1(au.Submit_btn(), "Submitted");
		Assert.assertTrue(au.add_User().isDisplayed());
		Log.info("User added successfully");
		hp.logoff();
		Log.endTestCase("add_new_user");
		
		}
	
	@Test(priority=2,groups = { "Regression" })
	public void verify_add_new_warehouse() throws Exception 
	{
		Log.startTestCase("add_new_warehouse");
		lp.LoginFn();
		act.click1(hp.settings(), "Clicked  settings menu");
		act.click1(awh.Warehouse_tab(), "Clicked  user tab");	
		act.click1(awh.add_Warehouse(), "Clicked AddWarehouse");	
		Log.info("Clicked add Warehouse button");
		ArrayList<String> exceldata=data.getData("AddWarehouse");
		act.type(awh.warehouseName(), exceldata.get(0));
		Log.info("Entered warehouse name");
		act.type(awh.warehouse_Phone(), exceldata.get(1));
		Log.info("Entered warehouse phone");
		act.type(awh.email(), exceldata.get(2));
		Log.info("Entered email");
		act.type(awh.address(), exceldata.get(3));
		Log.info("Entered address");
		act.click1(awh.Submit_btn3(), "Submitted");
		Assert.assertTrue(awh.add_Warehouse().isDisplayed());
		Log.info("Warehouse added successfully");
		hp.logoff();
		Log.endTestCase("add_new_warehouse");
	}
	
	
	
}
