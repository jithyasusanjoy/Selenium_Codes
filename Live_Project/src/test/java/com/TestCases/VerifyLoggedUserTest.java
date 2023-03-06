package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;

import WebElements.HomePage;
import WebElements.LoginPage;

public class VerifyLoggedUserTest extends BaseClass {
	@BeforeTest
	public void launch()
	{
		launchApp();
	}
	
	@Test
	public void user_name() 
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 
		HomePage hp= new HomePage(driver);	
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		Assert.assertEquals(hp.user_name().getText(),"  admin Doe");
		System.out.println("Admin user");
	}
}
