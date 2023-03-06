package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;

import WebElements.HomePage;
import WebElements.LoginPage;
import WebElements.StoresPage;

public class VerifyDeleteStoreTest extends BaseClass {
	@BeforeTest
	public void launch()
	{
		launchApp();
	}
	
	@Test
	public void user_edit_store() 
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp= new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.stores(), "Clicked");
		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");
		act.type(sp.search(), "Bun");
		act.click1(sp.delete_row(), "Clicked");
		act.type(sp.search(), "Bun");
		Assert.assertEquals(sp.No_Element().getText(),"No matching records found");
		System.out.println("Store Deleted");
	}
}
