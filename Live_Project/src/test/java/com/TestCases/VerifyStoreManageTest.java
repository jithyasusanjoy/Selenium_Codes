package com.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;
import com.project.Utilities.RetryAnalyzer;

public class VerifyStoreManageTest extends BaseClass {
	
	
	
	
	@Test(priority=1,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_add_store_zone() throws Exception 
	{
		Log.startTestCase("verify_add_store_zone");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.add_Zone(), "Clicked add zone icon");
		ArrayList<String> exceldata=data.getData("AddZone");
		act.type(sm.add_zone_Name(), exceldata.get(0));
		Log.info("Entered zone name");
		act.click1(sm.add_Zone_Submit_btn(), "submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("Zone added");
		Log.endTestCase("verify_add_store_zone");
	}
	
	@Test(priority=2,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_edit_store_zone() throws Exception 
	{
		Log.startTestCase("verify_edit_store_zone");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.edit_Zone(), "Clicked edit icon");		
		ArrayList<String> exceldata=data.getData("EditZone");
		act.type(sm.edit_Zone_Name(), exceldata.get(0));
		Log.info("Enter new zone name");
		act.click1(sm.edit_Zone_Submit_btn(), "Submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("Zone edited");
		Log.endTestCase("verify_edit_store_zone");
	}
	@Test(priority=3,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_delete_store_zone() 
	{
		Log.startTestCase("verify_delete_store_zone");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.delete_Zone(), "Clicked close icon");
		act.click1(sm.Delete_Zone_confirm(), "delete zone");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("Zone deleted");
		Log.endTestCase("verify_delete_store_zone");
	}
	
	@Test(priority=4,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_add_store_table() throws Exception 
	{
		Log.startTestCase("verify_add_store_table");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.add_table(), "Clicked add icon");
		ArrayList<String> exceldata=data.getData("AddTable");	 
		act.type(sm.Table_Name(), exceldata.get(0));
		Log.info("Entered table name");
		act.selectByValue(sm.Choose_Zone(), exceldata.get(1));
		Log.info("Selected zone");
		act.click1(sm.Submit_btn1(), "submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("table added");
		Log.endTestCase("verify_add_store_table");
	}
	
	@Test(priority=5,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_edit_store_table() throws Exception 
	{
		Log.startTestCase("verify_edit_store_table");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.Table_edit(), "Clicked edit icon");		
		ArrayList<String> exceldata=data.getData("EditTable");	
		act.type(sm.Table_Name(), exceldata.get(0));
		Log.info("Edited table name");
		act.click1(sm.Edit_table_Submit_btn(), "Submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		System.out.println("Table edited");
		Log.endTestCase("verify_edit_store_table");
	}
	
	@Test(priority=6,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_delete_store_table() 
	{
		Log.startTestCase("verify_delete_store_table");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.Table_delete(), "Clicked close icon");
		Log.info("Deleted table");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		System.out.println("Table deleted");
		Log.endTestCase("verify_delete_store_table");
	}
	
	@AfterMethod(groups = { "Regression" })
	public void after_method() {
		hp.logoff();
	}
	
}
