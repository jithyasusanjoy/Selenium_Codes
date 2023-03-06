package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;

import WebElements.HomePage;
import WebElements.LoginPage;
import WebElements.ProductPage;

public class VerifyProductFileDownloadTest extends BaseClass {
	@BeforeTest
	public void launch()
	{
		launchApp();
	}
	
	@Test
	public void user_add_product() throws InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp= new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.products(), "Clicked");
		ProductPage pp =new ProductPage(driver);
		Assert.assertEquals(pp.add_product().getText(),"Add Product");	
		act.click1(pp.download_CSV(), "Clicked");		
	}
}
