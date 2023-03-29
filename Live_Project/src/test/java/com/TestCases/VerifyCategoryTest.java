package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;

public class VerifyCategoryTest extends BaseClass {



	@Test(priority = 1)
	public void verify_add_product_category() throws Exception {
		Log.startTestCase("add_product_category");
		lp.LoginFn();
		act.click1(hp.categories(), "Clicked  categories menu");
		act.click1(hp.product_Category(), "Clicked");
		Log.info("Clicked  product sub menu");
		act.click1(ac1.add_Category(), "Clicked");
		Log.info("Clicked add category button");
		act.type(ac1.category_Name(), "Prod_Cat"+ran.nextInt());
		Log.info("Entered category name");
		act.click1(ac1.Submit_btn(), "Submitted");
		Assert.assertTrue(ac1.add_Category().isDisplayed());
		Log.info("Product category added successfully");
		hp.logoff();
		Log.endTestCase("add_product_category");
	}

	@Test(priority = 2)
	public void verify_add_expense_category() throws Exception {
		Log.startTestCase("add_expense_category");
		lp.LoginFn();
		act.click1(hp.categories(), "Clicked  categories menu");
		act.click1(hp.expense_Category(), "Clicked");
		Log.info("Clicked  product sub menu");
		act.click1(ac1.add_Category(), "Clicked");
		Log.info("Clicked add category button");
		act.type(ac1.category_Name(), "Exp_Cat"+ran.nextInt());
		Log.info("Entered category name");
		act.click1(ac1.Submit_btn(), "Submitted");
		Assert.assertTrue(ac1.add_Category().isDisplayed());
		Log.info("Product category added successfully");
		hp.logoff();
		Log.endTestCase("add_expense_category");
	}

}
