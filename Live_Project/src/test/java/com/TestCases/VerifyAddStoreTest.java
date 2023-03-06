package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import WebElements.AddStorePage;
import WebElements.HomePage;
import WebElements.LoginPage;
import WebElements.StoresPage;

public class VerifyAddStoreTest extends BaseClass {
	@BeforeTest
	public void launch()
	{
		launchApp();
	}
	
	@Test
	public void user_add_store() 
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp= new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.stores(), "Clicked");		
		StoresPage sp =new StoresPage(driver);
		Assert.assertEquals(sp.add_store().getText(),"Add Store");	
		act.click1(sp.add_store(), "Clicked");
		AddStorePage asp =new AddStorePage(driver);
		act.type(asp.storename(), "BunCafe");
		act.type(asp.email(), "buncafe@gmail.com");
		act.type(asp.country(), "India");
		act.type(asp.city(), "Trivandrum");
		act.type(asp.address(), "121 Nila");
		act.type(asp.storephone(), "04742524542");
		act.type(asp.customerfooter(), "Please Visit Again");
		act.click1(asp.Submit_btn(), "Clicked");
		act.fluentWait(driver, sp.search(), 5);
		act.type(sp.search(), "Bun");
		Assert.assertEquals(sp.First_Element().getText(),"BunCafe");
		System.out.println("Store added");
	}
}
