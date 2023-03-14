package com.TestCases;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;
import com.project.Utilities.RetryAnalyzer;

public class VerifyHomepageTest extends BaseClass {

	
	@Test(priority = 3,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_language_selection() {
		Log.startTestCase("verify_language_selection");
		lp.LoginFn();
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(), "CHOOSE A STORE");
		act.click1(hp.language_dropdown(), "Clicked dropdown");
		act.click1(hp.language(), "Selected Language");	
		Assert.assertTrue(hp.Language_displayed().isDisplayed());
		Log.info("Language Test passed");
		Log.endTestCase("verify_language_selection");
	}

	@Test(priority = 1,groups = { "Regression"})
	public void verify_logged_user_name() throws InterruptedException {
		Log.startTestCase("verify_logged_user_name");
		lp.LoginFn();
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(), "CHOOSE A STORE");
		Assert.assertEquals(hp.user_name().getText(), "  admin Doe");
		Log.info("Admin user");
		Log.endTestCase("verify_logged_user_name");
	}

	@Test(priority = 2,groups = { "Regression"})
	public void verify_home_menu_elements() {
		Log.startTestCase("verify_home_menu_elements");
		lp.LoginFn();
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(), "CHOOSE A STORE");
		List<String> list1 = new ArrayList<String>();
		List<WebElement> list2 = hp.menu();
		List<String> list3 = new ArrayList<String>();
		list1.add("POS");
		list1.add("PRODUCT");
		list1.add("STORES");
		list1.add("PEOPLE");
		list1.add("SALES");
		list1.add("EXPENSE");
		list1.add("CATEGORIES");
		list1.add("SETTING");
		list1.add("REPORTS");

		for (int i = 0; i < list1.size();) {
			for (WebElement j : list2) {
				if (list1.get(i).equalsIgnoreCase(j.getText())) {
					System.out.println(list1.get(i) + "=" + j.getText());
					i++;
					list3.add(j.getText());
				}
			}
			break;
		}
		Assert.assertEquals(list1, list3);
		Log.endTestCase("verify_home_menu_elements");
	}

	@AfterMethod(groups = { "Regression" })
	public void after_method() {
		hp.logoff();
	}

}
