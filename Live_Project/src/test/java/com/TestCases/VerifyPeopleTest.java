package com.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	
	@BeforeMethod(groups = { "Regression" })
	public void methods() {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		as = new AddSupplier(driver);
		aw = new AddWaiter(driver);
		ac = new AddCustomer(driver);
		data = new ExcelRead();
		lp.LoginFn();
	}
	
	@Test(priority=1,groups = { "Regression" })
	public void verify_add_supplier() throws Exception 
	{
		Log.startTestCase("verify_add_supplier");	
		act.click1(hp.people(), "Clicked");	
		Log.info("Clicked  people menu");
		act.click1(hp.suppliers(), "Clicked");	
		Log.info("Clicked  suppliers sub menu");
		act.click1(as.add_Supplier(), "Clicked");	
		Log.info("Clicked add suppliers button");
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
		Log.endTestCase("verify_add_supplier");
		}
	
	
	
	@Test(priority=2,groups = { "Regression" })
	public void verify_add_waiter() throws Exception 
	{	
		Log.startTestCase("verify_add_waiter");
		act.click1(hp.people(), "Clicked");	
		Log.info("clicked  people menu");
		act.click1(hp.waiters(), "Clicked");	
		Log.info("clicked  waiters sub menu");
		act.click1(aw.add_Waiter(), "Clicked");	
		Log.info("clicked add waiters button");
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
		Log.endTestCase("verify_add_waiter");
	}
	
	@Test(priority=3,groups = { "Regression" })
	public void verify_add_customer() throws Exception 
	{		
		Log.startTestCase("verify_add_customer");
		act.click1(hp.people(), "Clicked");	
		Log.info("clicked  people menu");
		act.click1(hp.Customers(), "Clicked");	
		Log.info("clicked customers sub menu");
		act.click1(ac.add_Customer(), "Clicked");	
		Log.info("clicked add customer button");
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
		Log.endTestCase("verify_add_customer");
	}
	
	@AfterMethod(groups = { "Regression" })
	public void after_method() {
		hp.logoff();
	}
}