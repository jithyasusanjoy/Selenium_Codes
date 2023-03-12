package com.TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.PageObjects.AddExpense;
import com.PageObjects.AddProductPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.PrintMenuPage;
import com.PageObjects.ProductPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;
import com.project.Utilities.RetryAnalyzer;

public class VerifyAddProductTest extends BaseClass {

	@BeforeGroups("smoke")
	public void before_it() {
		System.out.println("--------Before group----------");
	}

	@BeforeMethod(groups = { "Regression" })
	public void methods() {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		ae = new AddExpense(driver);
		pp = new ProductPage(driver);
		ap = new AddProductPage(driver);
		pmp= new PrintMenuPage(driver);
		data = new ExcelRead();
		lp.LoginFn();
		act.click1(hp.products(), "Clicked product menu");
	}

	@Test(groups = { "Regression" }, priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void verify_add_product() throws Exception {
		Log.startTestCase("verify_add_product");
		Assert.assertEquals(pp.add_product().getText(), "Add Product");
		act.click1(pp.add_product(), "Clicked add product button");
		ArrayList<String> exceldata = data.getData("AddProduct");
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
		act.type(ap.file_upload(), exceldata.get(9));
		Log.info("File selected");
		act.click1(ap.color_selection(), "color selected");
		act.click1(ap.Submit_btn(), "Submitted");
		act.fluentWait(driver, ap.Search(), 5);
		//act.click1(ap.Stock_close(), "Closed stock popup");
		act.type(ap.Search(), "A1234");
		Log.info("Entered search text");
		Assert.assertEquals(ap.First_Element().getText(), "A1234");
		Log.info("Product added");
		Log.endTestCase("verify_add_product");
	}

	@Test(groups = { "Regression" }, priority = 2)
	public void verify_file_download() throws InterruptedException {
		Log.startTestCase("verify_file_download");
		Assert.assertEquals(pp.add_product().getText(), "Add Product");
		act.click1(pp.download_CSV(), "Clicked");
		Log.endTestCase("verify_file_download");
	}

	@Test(groups = { "Regression" }, priority = 3)
	public void verify_file_upload() throws Exception {
		Log.startTestCase("verify_file_upload");
		ArrayList<String> exceldata = data.getData("AddProduct");
		act.click1(pp.upload_CSV(), "Clicked file upload button");
		act.type(pp.file_upload(), exceldata.get(9));
		Log.info("File selected");
		act.click1(pp.Submit_btn(), "Submitted");
		Assert.assertEquals(pp.add_product().getText(), "Add Product");
		Log.endTestCase("verify_file_upload");
	}
	
	@Test(groups = { "Regression" }, priority = 4)
	public void verify_print_menu() throws Exception {
		Log.startTestCase("verify_print_menu");
		act.click1(pp.print_Menu(), "Clicked print menu button");
		act.click1(pmp.print(), "Clicked print button");
		Thread.sleep(3000);
		Robot rb =new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Log.info("printed");
		Assert.assertTrue(pmp.label().isDisplayed());
		act.switchToOldWindow(driver);	
		act.click1(pmp.Close_btn(), "Closed");
		Thread.sleep(3000);
		Log.endTestCase("verify_print_menu");
	}
	
	

	@AfterGroups("Regression")
	public void after_it() {
		System.out.println("--------After group----------");
	}

	@AfterMethod(groups = { "Regression" })
	public void after_method() {
		hp.logoff();
	}

}
