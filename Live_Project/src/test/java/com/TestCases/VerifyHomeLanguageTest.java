package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;

import WebElements.HomePage;
import WebElements.LoginPage;

public class VerifyHomeLanguageTest extends BaseClass {
	
	
	@BeforeTest
	public void launch()
	{
		launchApp();
	}
	@Test
	public void select_language()
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp =new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.language_dropdown(), "Clicked dropdown");
		act.click1(hp.language(), "Selected Language");	
		Assert.assertTrue(hp.Language_displayed().isDisplayed());
		System.out.println("Language Test passed");;
	}
	
	

}
