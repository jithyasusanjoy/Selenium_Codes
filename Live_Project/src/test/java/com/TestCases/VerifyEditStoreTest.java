package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;

import WebElements.AddStorePage;
import WebElements.HomePage;
import WebElements.LoginPage;
import WebElements.StoresPage;

public class VerifyEditStoreTest  extends BaseClass {
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
		act.click1(sp.Edit_Row(), "Clicked");
		AddStorePage asp =new AddStorePage(driver);
		act.type(asp.storename(), "BunCafe1");
		act.click1(asp.Submit_btn(), "Clicked");
		act.fluentWait(driver, sp.search(), 5);
		act.type(sp.search(), "Bun");
		Assert.assertEquals(sp.First_Element().getText(),"BunCafe1");
		System.out.println("Store Edited");
	}

}
