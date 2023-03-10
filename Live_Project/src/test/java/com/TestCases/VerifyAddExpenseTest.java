package com.TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddExpense;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

public class VerifyAddExpenseTest extends BaseClass {
	@BeforeTest
	public void launch() {
		launchApp();
		common_methods();
	}

	public void common_methods() {

		lp.LoginFn();
		HomePage hp = new HomePage(driver);
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(), "CHOOSE A STORE");

	}

	@Test(priority = 1)
	public void add_expense() throws Exception {
		Log.startTestCase("add_expense");
		HomePage hp = new HomePage(driver);
		act.click1(hp.expenses(), "Clicked");
		Log.info("clicked  expenses menu");
		AddExpense ae = new AddExpense(driver);
		act.click1(ae.add_Expense(), "Clicked");
		Log.info("clicked add Expense button");
		ExcelRead data = new ExcelRead();
		ArrayList<String> exceldata = data.getData("AddExpense");		
		act.type(ae.Date(), exceldata.get(0));
	    Log.info("Entered date");
		act.type(ae.reference(), exceldata.get(1));
		Log.info("Entered reference");
		Thread.sleep(3000);
		act.selectByValue(ae.category(),exceldata.get(2));
		Log.info("Selected category");
		act.selectByValue(ae.store(), exceldata.get(3));
		Log.info("Selected store");
		act.type(ae.amount(), exceldata.get(4));
		Log.info("Entered amount");
		act.type(ae.attachment(), exceldata.get(5));
		Log.info("Selected file");
		act.type(ae.note(), exceldata.get(6));
		Log.info("Entered note");
		act.click1(ae.Submit_btn(), "Submitted");
		Assert.assertTrue(ae.add_Expense().isDisplayed());
		Log.info("Expense added successfully");
		Log.endTestCase("add_expense");
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
