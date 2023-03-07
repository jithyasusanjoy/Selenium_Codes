package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddProductPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.ProductPage;

public class VerifyAddProductTest extends BaseClass {
	@BeforeGroups("smoke")  
	public void before_it()  
	{  
	System.out.println("--------Before group----------");  
	}  
	@BeforeTest
	public void launch()
	{
		launchApp();
	}
	
	@AfterGroups("smoke") 
	public void after_it() 
	{
	System.out.println("--------After group----------");
	}
	
	@Test(groups={"smoke"})
	public void user_add_product()
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp= new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.products(), "Clicked");
		ProductPage pp =new ProductPage(driver);
		Assert.assertEquals(pp.add_product().getText(),"Add Product");	
		act.click1(pp.add_product(), "Clicked");
		AddProductPage ap =new AddProductPage(driver);
		act.selectByValue(ap.type(), "1");
		act.type(ap.code(), "A1234");
		act.type(ap.name(), "Grapes");
		act.selectByValue(ap.category(), "fruits");
		act.type(ap.Tax(), "15000");
		act.selectByValue(ap.Tax_method(), "1");
		act.type(ap.Price(), "1500");
		act.type(ap.product_options(), "More Cheese");
		act.type(ap.product_description(), "desc");
		act.type(ap.file_upload(),"C:\\Users\\jithya susan\\Downloads\\qa-lucee_bugs\\d1.png");
		act.click1(ap.color_selection(), "color selected");
		act.click1(ap.Submit_btn(), "Submit");
		act.fluentWait(driver, ap.Search(), 5);
		act.type(ap.Search(), "A1234");
		Assert.assertEquals(ap.First_Element().getText(),"A1234");
		System.out.println("Product added");
	}

}
