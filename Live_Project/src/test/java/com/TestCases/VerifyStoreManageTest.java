package com.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.StoreManage;
import com.PageObjects.StoresPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

public class VerifyStoreManageTest extends BaseClass {
	
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
		act.click1(hp.stores(), "Clicked");	
		Log.info("clicked  store menu");
		StoresPage sp= new StoresPage(driver);
		act.click1(sp.Manage_Table(), "Clicked manage store icon ");
		StoreManage sm=new StoreManage(driver);
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
	}
	
	@Test(priority=1)
	public void add_store_zone() throws Exception 
	{
		Log.startTestCase("add_store_zone");
		StoreManage sm=new StoreManage(driver);
		act.click1(sm.add_Zone(), "Clicked add zone icon");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddZone");
		act.type(sm.add_zone_Name(), exceldata.get(0));
		Log.info("Entered zone name");
		act.click1(sm.add_Zone_Submit_btn(), "submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("Zone added");
		Log.endTestCase("add_store_zone");
	}
	
	@Test(priority=2)
	public void edit_store_zone() throws Exception 
	{
		Log.startTestCase("edit_store_zone");
		StoreManage sm=new StoreManage(driver);
		act.click1(sm.edit_Zone(), "Clicked edit icon");	
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("EditZone");
		act.type(sm.edit_Zone_Name(), exceldata.get(0));
		Log.info("Enter new zone name");
		act.click1(sm.edit_Zone_Submit_btn(), "Submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("Zone edited");
		Log.endTestCase("edit_store_zone");
	}
	@Test(priority=3)
	public void delete_store_zone() 
	{
		Log.startTestCase("delete_store_zone");
		StoreManage sm=new StoreManage(driver);
		act.click1(sm.delete_Zone(), "Clicked close icon");
		act.click1(sm.Delete_Zone_confirm(), "delete zone");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("Zone deleted");
		Log.endTestCase("delete_store_zone");
	}
	
	@Test(priority=4)
	public void add_store_table() throws Exception 
	{
		Log.startTestCase("add_store_table");
		StoreManage sm=new StoreManage(driver);
		act.click1(sm.add_table(), "Clicked add icon");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddTable");	 
		act.type(sm.Table_Name(), exceldata.get(0));
		Log.info("Entered table name");
		act.selectByValue(sm.Choose_Zone(), exceldata.get(1));
		Log.info("Selected zone");
		act.click1(sm.Submit_btn1(), "submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		Log.info("table added");
		Log.endTestCase("add_store_table");
	}
	
	@Test(priority=5)
	public void edit_store_table() throws Exception 
	{
		Log.startTestCase("edit_store_table");
		StoreManage sm=new StoreManage(driver);
		act.click1(sm.Table_edit(), "Clicked edit icon");		
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("EditTable");	
		act.type(sm.Table_Name(), exceldata.get(0));
		Log.info("Edited table name");
		act.click1(sm.Edit_table_Submit_btn(), "Submitted");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		System.out.println("Table edited");
		Log.endTestCase("edit_store_table");
	}
	
	@Test(priority=6)
	public void delete_store_table() 
	{
		Log.startTestCase("delete_store_table");
		StoreManage sm=new StoreManage(driver);
		act.click1(sm.Table_delete(), "Clicked close icon");
		Log.info("Deleted table");
		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
		System.out.println("Table deleted");
		Log.endTestCase("delete_store_table");
	}
	

	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
