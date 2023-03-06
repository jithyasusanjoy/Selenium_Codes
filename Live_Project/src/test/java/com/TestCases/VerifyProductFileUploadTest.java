package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;

import WebElements.HomePage;
import WebElements.LoginPage;
import WebElements.ProductPage;

public class VerifyProductFileUploadTest extends BaseClass {
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
		act.click1(pp.upload_CSV(), "Clicked");
		act.type(pp.file_upload(),"C:\\Users\\jithya susan\\Downloads\\qa-lucee_bugs\\d1.png");
		act.click1(pp.Submit_btn(), "Clicked");
		Assert.assertEquals(pp.add_product().getText(),"Add Product");
		}
}
