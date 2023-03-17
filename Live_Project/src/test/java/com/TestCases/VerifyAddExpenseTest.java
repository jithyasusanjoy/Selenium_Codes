package com.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;
import com.project.Utilities.RetryAnalyzer;

public class VerifyAddExpenseTest extends BaseClass {
	
	
	@Test(groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_expense_addition() throws Exception {
		Log.startTestCase("verify_expense_addition");
		lp.LoginFn();
		Thread.sleep(3000);
		act.click1(hp.expenses(), "clicked  expenses menu");
		act.click1(ae.add_Expense(), "clicked add Expense button");
		ArrayList<String> exceldata = data.getData("AddExpense");		
		act.type(ae.Date(), exceldata.get(0));
	    Log.info("Entered date");
		act.type(ae.reference(), exceldata.get(1));
		Log.info("Entered reference");
		act.selectByValue(ae.category(),exceldata.get(2));
		Log.info("Selected category");
		act.selectByValue(ae.store(), exceldata.get(3));
		Log.info("Selected store");
		act.type(ae.amount(), exceldata.get(4));
		Log.info("Entered amount");
		act.type(ae.attachment(), "C:\\Users\\jithya susan\\git\\Selenium_Codes\\Live_Project\\ExcelFile\\a2.png");
		Log.info("Selected file");
		act.type(ae.note(), exceldata.get(6));
		Log.info("Entered note");
		act.click1(ae.Submit_btn(), "Submitted");
		Assert.assertTrue(ae.add_Expense().isDisplayed());
		Log.info("Expense added successfully");
		hp.logoff();
		Log.endTestCase("verify_expense_addition");
	}

	

}
