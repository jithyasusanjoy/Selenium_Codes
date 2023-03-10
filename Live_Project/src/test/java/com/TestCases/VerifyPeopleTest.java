package com.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddCustomer;
import com.PageObjects.AddSupplier;
import com.PageObjects.AddWaiter;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

public class VerifyPeopleTest extends BaseClass {
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
		Log.info("user logged in");
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		
	}
	
	@Test(priority=1)
	public void add_supplier() throws Exception 
	{
		Log.startTestCase("add_supplier");
		HomePage hp= new HomePage(driver);
		act.click1(hp.people(), "Clicked");	
		Log.info("Clicked  people menu");
		act.click1(hp.suppliers(), "Clicked");	
		Log.info("Clicked  suppliers sub menu");
		AddSupplier as = new AddSupplier(driver);
		act.click1(as.add_Supplier(), "Clicked");	
		Log.info("Clicked add suppliers button");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddSupplier");
		act.type(as.supplier_Name(), exceldata.get(0));
		Log.info("Entered suppliers name");
		act.type(as.supplier_Email(), exceldata.get(1));
		Log.info("Entered suppliers emailid");
		act.type(as.supplier_Phone(), exceldata.get(2));
		Log.info("Entered suppliers phoneno");
		act.type(as.note(), exceldata.get(3));
		Log.info("Entered  note");
		act.click1(as.Submit_btn(), "Submitted");
		Assert.assertTrue(as.add_Supplier().isDisplayed());
		Log.info("Supplier added successfully");
		Log.endTestCase("add_supplier");
		}
	
	
	
	@Test(priority=2)
	public void add_waiter() throws Exception 
	{
		HomePage hp= new HomePage(driver);
		act.click1(hp.people(), "Clicked");	
		Log.info("clicked  people menu");
		act.click1(hp.waiters(), "Clicked");	
		Log.info("clicked  waiters sub menu");
		AddWaiter aw = new AddWaiter(driver);
		act.click1(aw.add_Waiter(), "Clicked");	
		Log.info("clicked add waiters button");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddWaiter");
		act.type(aw.waiter_Name(), exceldata.get(0));
		Log.info("entered waiter name");
		act.type(aw.waiter_Phone(), exceldata.get(1));
		Log.info("entered waiter emailid");
		act.type(aw.waiter_Email(), exceldata.get(2));
		Log.info("entered waiter phoneno");
		act.selectByValue(aw.waiter_Store(),exceldata.get(3));
		Log.info("selected  store");
		act.click1(aw.Submit_btn(), "Submitted");
		Assert.assertTrue(aw.add_Waiter().isDisplayed());
		Log.info("Waiter added successfully");
	}
	
	@Test(priority=3)
	public void add_customer() throws Exception 
	{
		HomePage hp= new HomePage(driver);
		act.click1(hp.people(), "Clicked");	
		Log.info("clicked  people menu");
		act.click1(hp.Customers(), "Clicked");	
		Log.info("clicked customers sub menu");
		AddCustomer ac = new AddCustomer(driver);
		act.click1(ac.add_Customer(), "Clicked");	
		Log.info("clicked add customer button");
		ExcelRead data= new ExcelRead();
		ArrayList<String> exceldata=data.getData("AddCustomer");
		act.type(ac.customer_Name(), exceldata.get(0));
		Log.info("entered customer name");
		act.type(ac.customer_Phone(), exceldata.get(1));
		Log.info("entered customer phoneno");
		act.type(ac.customer_Email(), exceldata.get(2));
		Log.info("entered customer emailid ");
		act.type(ac.customer_Discount(), exceldata.get(3));
		Log.info("entered  discount");
		act.click1(ac.Submit_btn(), "Submitted");
		Assert.assertTrue(ac.add_Customer().isDisplayed());
		Log.info("customer added successfully");
		Log.endTestCase("VerifyPeopleTest");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
