package com.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddProductPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.ProductPage;
import com.project.Utilities.ExcelRead;

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
		common_methods();
	}
	
	public void common_methods()
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp =new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.products(), "Clicked");
	}
	
	@Test(groups={"smoke"},priority=1)
	public void user_add_product() throws Exception
	{	
		ProductPage pp =new ProductPage(driver);
		Assert.assertEquals(pp.add_product().getText(),"Add Product");	
		act.click1(pp.add_product(), "Clicked");
		AddProductPage ap =new AddProductPage(driver);
		
		 ExcelRead data= new ExcelRead();
		 ArrayList<String> exceldata=data.getData("AddProduct");
		act.selectByValue(ap.type(), exceldata.get(0));
		act.type(ap.code(), exceldata.get(1));
		act.type(ap.name(), exceldata.get(2));
		act.selectByValue(ap.category(), exceldata.get(3));
		act.type(ap.Tax(), exceldata.get(4));
		act.selectByValue(ap.Tax_method(), exceldata.get(5));
		act.type(ap.Price(), exceldata.get(6));
		act.type(ap.product_options(), exceldata.get(7));
		act.type(ap.product_description(), exceldata.get(8));
		act.fluentWait(driver, ap.file_upload(), 5);
		act.type(ap.file_upload(),exceldata.get(9));
		act.click1(ap.color_selection(), "color selected");
		act.click1(ap.Submit_btn(), "Submit");
		act.fluentWait(driver, ap.Search(), 5);
		act.click1(ap.Stock_close(), "Closed stock popup");
		act.type(ap.Search(), "A1234");
		Assert.assertEquals(ap.First_Element().getText(),"A1234");
		System.out.println("Product added");
	}
	
	@Test
	public void file_download() throws InterruptedException 
	{
		ProductPage pp =new ProductPage(driver);
		Assert.assertEquals(pp.add_product().getText(),"Add Product");	
		act.click1(pp.download_CSV(), "Clicked");		
	}
	
	@Test
	public void file_upload() throws InterruptedException 
	{
		ProductPage pp =new ProductPage(driver);
		act.click1(pp.upload_CSV(), "Clicked");
		act.type(pp.file_upload(),"C:\\Users\\jithya susan\\Downloads\\qa-lucee_bugs\\d1.png");
		act.click1(pp.Submit_btn(), "Clicked");
		Assert.assertEquals(pp.add_product().getText(),"Add Product");
		}
	

	@AfterGroups("smoke") 
	public void after_it() 
	{
	System.out.println("--------After group----------");
	}
	
	
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
