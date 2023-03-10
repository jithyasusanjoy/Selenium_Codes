package com.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddCategory;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

public class VerifyCategoryTest extends BaseClass {
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
		HomePage hp= new HomePage(driver);
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		
	}
	
	@Test(priority=1)
	public void add_product_category() throws Exception 
	{
		Log.startTestCase("add_product_category");
		HomePage hp= new HomePage(driver);
		act.click1(hp.categories(), "Clicked");	
		Log.info("Clicked  categories menu");
		act.click1(hp.product_Category(), "Clicked");	
		Log.info("Clicked  product sub menu");
		AddCategory ac1 = new AddCategory(driver);
		act.click1(ac1.add_Category(), "Clicked");	
		Log.info("Clicked add category button");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddProductCategory");
		act.type(ac1.category_Name(), exceldata.get(0));
		Log.info("Entered category name");
		act.click1(ac1.Submit_btn(), "Submitted");
		Assert.assertTrue(ac1.add_Category().isDisplayed());
		Log.info("Product category added successfully");
		Log.endTestCase("add_product_category");
		}
	
	@Test(priority=2)
	public void add_expense_category() throws Exception 
	{
		Log.startTestCase("add_expense_category");
		HomePage hp= new HomePage(driver);
		act.click1(hp.categories(), "Clicked");	
		Log.info("Clicked  categories menu");
		act.click1(hp.expense_Category(), "Clicked");	
		Log.info("Clicked  product sub menu");
		AddCategory ac2 = new AddCategory(driver);
		act.click1(ac2.add_Category(), "Clicked");	
		Log.info("Clicked add category button");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddExpenseCategory");
		act.type(ac2.category_Name(), exceldata.get(0));
		Log.info("Entered category name");
		act.click1(ac2.Submit_btn(), "Submitted");
		Assert.assertTrue(ac2.add_Category().isDisplayed());
		Log.info("Product category added successfully");
		Log.endTestCase("add_expense_category");
		}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
}
