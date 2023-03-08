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

public class VerifyStoreTest extends BaseClass {
	@BeforeTest
	public void launch()
	{
		launchApp();
		common_methods();
	}
		
	public void common_methods()
	{
		Log.startTestCase("VerifyAddStoreTest");
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp= new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		Log.info("user is going to click  store menu");
		act.click1(hp.stores(), "Clicked");	
	}
	
	@Test(priority=1)
	public void store_name_descending() 
	{
		StoresPage sp =new StoresPage(driver);
		act.click1(sp.sort_descending(),"Clicked storename");
		Assert.assertEquals(sp.First_Element().getText(), "VKS Store2147483647");
		System.out.println("Store name sorted in descending order");
		store_name_ascending();
	}
	
	
	public void store_name_ascending() 
	{	
		StoresPage sp =new StoresPage(driver);
		act.click1(sp.sort_ascending(),"Clicked storename");
		Assert.assertEquals(sp.First_Element().getText(), "Ajstores");
		System.out.println("Store name sorted in ascending order");
	}
	
	@Test(priority=3)
	public void user_add_store() throws Exception 
	{
		
		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");	
		act.click1(sp.add_store(), "Clicked");
		AddStorePage asp =new AddStorePage(driver);
		
		 ExcelRead data= new ExcelRead();
		 ArrayList<String> exceldata=data.getData("AddStore");
		
		act.type(asp.storename(), exceldata.get(0));
		act.type(asp.email(), exceldata.get(1));
		act.type(asp.country(), exceldata.get(2));
		act.type(asp.city(), exceldata.get(3));
		act.type(asp.address(), exceldata.get(4));
		act.type(asp.storephone(), exceldata.get(5));
		act.type(asp.customerfooter(), exceldata.get(6));
		act.click1(asp.Submit_btn(), "Clicked");
		act.fluentWait(driver, sp.search(), 5);
		act.type(sp.search(), "Bun");
		Assert.assertEquals(sp.First_Element().getText(),"BunCafe");
		System.out.println("Store added");
		Log.endTestCase("VerifyAddStoreTest");
	}
	
	@Test(priority=5)
	public void user_delete_store() 
	{
		
		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");
		act.type(sp.search(), "Bun");
		act.click1(sp.delete_row(), "Clicked");
		act.type(sp.search(), "Bun");
		Assert.assertEquals(sp.No_Element().getText(),"No matching records found");
		System.out.println("Store Deleted");
	}
	
	@Test(priority=4)
	public void user_edit_store() 
	{

		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");
		act.type(sp.search(), "Bun");
		act.click1(sp.Edit_Row(), "Clicked");
		AddStorePage asp =new AddStorePage(driver);
		act.type(asp.storename(), "BunCafe1");
		act.click1(asp.Submit_btn(), "Clicked");
		act.fluentWait(driver, sp.search(), 5);
		act.type(sp.search(), "Bun");
		Assert.assertEquals(sp.First_Element().getText(),"BunCafe1");
		System.out.println("Store Edited");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
