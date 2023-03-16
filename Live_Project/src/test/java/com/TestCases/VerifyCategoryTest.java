package com.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;

public class VerifyCategoryTest extends BaseClass {



	@Test(priority = 1,groups = { "Regression" })
	public void verify_add_product_category() throws Exception {
		Log.startTestCase("add_product_category");
		lp.LoginFn();
		act.click1(hp.categories(), "Clicked  categories menu");
		act.click1(hp.product_Category(), "Clicked");
		Log.info("Clicked  product sub menu");
		act.click1(ac1.add_Category(), "Clicked");
		Log.info("Clicked add category button");
		ArrayList<String> exceldata = data.getData("AddProductCategory");
		act.type(ac1.category_Name(), exceldata.get(0));
		Log.info("Entered category name");
		act.click1(ac1.Submit_btn(), "Submitted");
		Assert.assertTrue(ac1.add_Category().isDisplayed());
		Log.info("Product category added successfully");
		hp.logoff();
		Log.endTestCase("add_product_category");
	}

	@Test(priority = 2,groups = { "Regression" })
	public void verify_add_expense_category() throws Exception {
		Log.startTestCase("add_expense_category");
		lp.LoginFn();
		act.click1(hp.categories(), "Clicked  categories menu");
		act.click1(hp.expense_Category(), "Clicked");
		Log.info("Clicked  product sub menu");
		act.click1(ac1.add_Category(), "Clicked");
		Log.info("Clicked add category button");
		ArrayList<String> exceldata = data.getData("AddExpenseCategory");
		act.type(ac1.category_Name(), exceldata.get(0));
		Log.info("Entered category name");
		act.click1(ac1.Submit_btn(), "Submitted");
		Assert.assertTrue(ac1.add_Category().isDisplayed());
		Log.info("Product category added successfully");
		hp.logoff();
		Log.endTestCase("add_expense_category");
	}

}
