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
import com.project.Utilities.Log;

public class VerifyAddProductTest extends BaseClass {
	
	@BeforeGroups("smoke")  
	public void before_it()  
	{  
	System.out.println("--------Before group----------");  
	}  
	
	@BeforeTest(groups={"Regression"})
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
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.products(), "Clicked");
	}
	
	@Test(groups={"Regression"},priority=1)
	public void user_add_product() throws Exception
	{	
		Log.startTestCase("user_add_product");
		ProductPage pp =new ProductPage(driver);
		Assert.assertEquals(pp.add_product().getText(),"Add Product");	
		act.click1(pp.add_product(), "Clicked add product button");
		AddProductPage ap =new AddProductPage(driver);
		 ExcelRead data= new ExcelRead();
		 ArrayList<String> exceldata=data.getData("AddProduct");
		act.selectByValue(ap.type(), exceldata.get(0));
		Log.info("Entered product type");
		act.type(ap.code(), exceldata.get(1));
		Log.info("Entered product code");
		act.type(ap.name(), exceldata.get(2));
		Log.info("Entered product name");
		act.selectByValue(ap.category(), exceldata.get(3));
		Log.info("Selected product category");
		act.type(ap.Tax(), exceldata.get(4));
		Log.info("Entered product Tax");
		act.selectByValue(ap.Tax_method(), exceldata.get(5));
		Log.info("Selected product Tax method");
		act.type(ap.Price(), exceldata.get(6));
		Log.info("Entered product Price");
		act.type(ap.product_options(), exceldata.get(7));
		Log.info("Entered product options");
		act.type(ap.product_description(), exceldata.get(8));
		Log.info("Entered product description");
		act.fluentWait(driver, ap.file_upload(), 5);
		act.type(ap.file_upload(),exceldata.get(9));
		Log.info("File selected");
		act.click1(ap.color_selection(), "color selected");
		act.click1(ap.Submit_btn(), "Submitted");
		act.fluentWait(driver, ap.Search(), 5);
		act.click1(ap.Stock_close(), "Closed stock popup");
		act.type(ap.Search(), "A1234");
		Log.info("Entered search text");
		Assert.assertEquals(ap.First_Element().getText(),"A1234");
		Log.info("Product added");
		Log.endTestCase("user_add_product");
	}
	
	@Test(groups={"Regression"})
	public void file_download() throws InterruptedException 
	{
		Log.startTestCase("file_download");
		ProductPage pp =new ProductPage(driver);
		Assert.assertEquals(pp.add_product().getText(),"Add Product");	
		act.click1(pp.download_CSV(), "Clicked");
		Log.endTestCase("file_download");
	}
	
	@Test(groups={"Regression"})
	public void file_upload() throws Exception 
	{
		Log.startTestCase("file_upload");
		 ExcelRead data= new ExcelRead();
		 ArrayList<String> exceldata=data.getData("AddProduct");
		ProductPage pp =new ProductPage(driver);
		act.click1(pp.upload_CSV(), "Clicked file upload button");
		act.type(pp.file_upload(),exceldata.get(9));
		Log.info("File selected");
		act.click1(pp.Submit_btn(), "Submitted");
		Assert.assertEquals(pp.add_product().getText(),"Add Product");
		Log.endTestCase("file_upload");
		}
	

	@AfterGroups("Regression") 
	public void after_it() 
	{
	System.out.println("--------After group----------");
	}
	
	
	@AfterTest(groups={"Regression"})
	public void close()
	{
		driver.close();
	}

}
