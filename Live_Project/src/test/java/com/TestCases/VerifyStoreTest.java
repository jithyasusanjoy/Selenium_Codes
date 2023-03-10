package com.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddStorePage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.StoresPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

import com.project.Utilities.RetryAnalyzer;

public class VerifyStoreTest extends BaseClass {
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
		Log.info("user logged in");
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.stores(), "Clicked");	
		Log.info("user clicked store menu");
	}
	
	@Test(priority=1)
	public void store_name_descending() 
	{
		Log.startTestCase("store_name_descending");
		StoresPage sp =new StoresPage(driver);
		act.click1(sp.sort_descending(),"Clicked storename");
		Log.info("Store name sorted in descending order");
		Assert.assertEquals(sp.First_Element().getText(), "VKS Store2147483647");	
		Log.endTestCase("store_name_descending");
		store_name_ascending();
		
	}
	
	
	public void store_name_ascending() 
	{	
		Log.startTestCase("store_name_ascending");
		StoresPage sp =new StoresPage(driver);
		act.click1(sp.sort_ascending(),"Clicked storename");
		Log.info("Store name sorted in ascending order");
		Assert.assertEquals(sp.First_Element().getText(), "Ajstores");
		Log.endTestCase("store_name_ascending");
	}
	
	@Test(priority=3)
	public void user_add_store() throws Exception 
	{
		Log.startTestCase("user_add_store");
		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");	
		act.click1(sp.add_store(), "Clicked Add store button");
		AddStorePage asp =new AddStorePage(driver);
		 ExcelRead data= new ExcelRead();
		 ArrayList<String> exceldata=data.getData("AddStore");
		act.type(asp.storename(), exceldata.get(0));
		Log.info("entered storename");
		act.type(asp.email(), exceldata.get(1));
		Log.info("entered email");
		act.type(asp.country(), exceldata.get(2));
		Log.info("entered country");
		act.type(asp.city(), exceldata.get(3));
		Log.info("entered city");
		act.type(asp.address(), exceldata.get(4));
		Log.info("entered address");
		act.type(asp.storephone(), exceldata.get(5));
		Log.info("entered storephone");
		act.type(asp.customerfooter(), exceldata.get(6));
		Log.info("entered customerfooter");
		act.click1(asp.Submit_btn(), "Submitted");
		act.fluentWait(driver, sp.search(), 5);
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		Assert.assertEquals(sp.First_Element().getText(),"BunCafe");
		Log.info("Store added");
		Log.endTestCase("user_add_store");
	}
	
	@Test(priority=5)
	public void user_delete_store() 
	{
		Log.endTestCase("user_delete_store");
		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		act.click1(sp.delete_row(), "clicked delete icon");
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		Assert.assertEquals(sp.No_Element().getText(),"No matching records found");
		Log.info("Store Deleted");
		Log.endTestCase("user_delete_store");
	}
	
	@Test(priority=4,retryAnalyzer=RetryAnalyzer.class)
	public void user_edit_store() 
	{
		Log.endTestCase("user_edit_store");
		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		act.click1(sp.Edit_Row(), "Clicked edit icon");
		AddStorePage asp =new AddStorePage(driver);
		act.type(asp.storename(), "BunCafe1");
		Log.info("entered storename");
		act.click1(asp.Submit_btn(), "Submitted");
		act.fluentWait(driver, sp.search(), 5);
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		Assert.assertEquals(sp.First_Element().getText(),"BunCafe1");
		Log.info("Store Edited");
		Log.endTestCase("user_edit_store");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
