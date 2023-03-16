package com.TestCases;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;

import com.project.Utilities.RetryAnalyzer;

public class VerifyStoreTest extends BaseClass {

	@Test(priority = 1,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_sort_store_name_descending_order() {
		Log.startTestCase("verify_sort_store_name_descending_order"); 
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		act.click1(sp.sort_descending(), "Clicked storename");
		Log.info("Store name sorted in descending order");
		Assert.assertEquals(sp.First_Element().getText(), "VKS Store2147483647");
		hp.logoff();
		Log.endTestCase("verify_sort_store_name_descending_order");

	}
	@Test(priority = 2,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_sort_store_name_ascending_order() {
	
		Log.startTestCase("verify_sort_store_name_ascending_order");
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		act.click1(sp.sort_descending(), "Clicked storename");
		act.click1(sp.sort_ascending(), "Clicked storename");
		Log.info("Store name sorted in ascending order");
		Assert.assertEquals(sp.First_Element().getText(), "AJStores");
		hp.logoff();
		Log.endTestCase("verify_sort_store_name_ascending_order");
	}

	@Test(priority = 3,groups = { "Regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void verify_add_store() throws Exception {
		Log.startTestCase("verify_add_store");
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		Assert.assertEquals(sp.add_store().getText(), "Add Store");
		act.click1(sp.add_store(), "Clicked Add store button");
		ArrayList<String> exceldata = data.getData("AddStore");
		act.type(asp.storename(), exceldata.get(0));
		Log.info("entered storename");
		act.type(asp.email(), exceldata.get(1));
		Log.info("entered email");
		act.type(asp.country(), exceldata.get(2));
		Log.info("entered country");
		act.type(asp.city(), exceldata.get(3));
		Log.info("entered city");
		act.type(asp.address(), exceldata.get(4));
		Log.info("entered address");
		act.type(asp.storephone(), exceldata.get(5));
		Log.info("entered storephone");
		act.type(asp.customerfooter(), exceldata.get(6));
		Log.info("entered customerfooter");
		act.click1(asp.Submit_btn(), "Submitted");
		asp.fluentwait(sp.search(), 5);
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		Assert.assertEquals(sp.First_Element().getText(), "BunCafe");
		Log.info("Store added");
		hp.logoff();
		Log.endTestCase("verify_add_store");
	}

	@Test(priority = 5,groups = { "Regression" })
	public void verify_delete_store() {
		Log.endTestCase("verify_delete_store");
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		Assert.assertEquals(sp.add_store().getText(), "Add Store");
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		act.click1(sp.delete_row(), "clicked delete icon");
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		Assert.assertEquals(sp.No_Element().getText(), "No matching records found");
		Log.info("Store Deleted");
		hp.logoff();
		Log.endTestCase("verify_delete_store");
	}

	@Test(priority = 4, retryAnalyzer = RetryAnalyzer.class,groups = { "Regression" })
	public void verify_edit_store() {
		Log.startTestCase("verify_edit_store");
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		Assert.assertEquals(sp.add_store().getText(), "Add Store");
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		act.click1(sp.Edit_Row(), "Clicked edit icon");
		act.type(asp.storename(), "BunCafe1");
		Log.info("entered storename");
		act.click1(asp.Submit_btn(), "Submitted");
		asp.fluentwait(sp.search(), 5);
		act.type(sp.search(), "Bun");
		Log.info("entered search text");
		Assert.assertEquals(sp.First_Element().getText(), "BunCafe1");
		Log.info("Store Edited");
		hp.logoff();
		Log.endTestCase("verify_edit_store");
	}
	@Test(priority=6,groups = { "Regression" })
	public void verify_sort_store_coulmns() {
		Log.startTestCase("verify_sort_store_coulmns");
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		List<WebElement> list1 = sp.table_headings();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		list2.add("Store Name");
		list2.add("Email");
		list2.add("Store Phone");
		list2.add("Country");
		list2.add("City");
		list2.add("Action");
		for (int i = 0; i < list2.size();) {
			for (WebElement j : list1) {
				if (list2.get(i).equalsIgnoreCase(j.getText())) {

					System.out.println(list2.get(i) + "=" + j.getText());
					i++;
					list3.add(j.getText());
				}
			}
			break;
		}
		Assert.assertEquals(list2, list3);	
		hp.logoff();
		Log.endTestCase("verify_sort_store_coulmns");
	}
	@Test(priority=7,groups = { "Regression" })
	public void verify_show_dropdown() {
		Log.startTestCase("verify_show_dropdown"); 
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		act.selectByValue(sp.show_drop(), "25");
		Log.info("Value selected from dropdown");
		List<WebElement> list1 = sp.table_rows();
		Assert.assertEquals(list1.size(), 25);
		hp.logoff();
		Log.endTestCase("verify_show_dropdown");
	}
	@Test(priority=8,groups = { "Regression" })
	public void verify_store_search() {
		Log.startTestCase("verify_store_search"); 
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		act.type(sp.search(), "Ajstor");
		Log.info("Text entered");
		List<WebElement> list1 = sp.table_rows();
		List<String> list2 = new ArrayList<String>();
		
			for (WebElement j : list1) {
				if(j.getText().contains("Ajstor"))
				{
				list2.add(j.getText());
				}			
			}		
		Assert.assertTrue(list2.contains("Ajstory"));	
		hp.logoff();
		Log.endTestCase("verify_store_search");
	}
	@Test(priority=9,groups = { "Regression" })
	public void verify_storepage_pagination() {
		Log.startTestCase("verify_storepage_pagination"); 
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked store menu");
		act.click1(sp.pagination(), "Clicked page no");
		Assert.assertTrue(sp.validate_Page().getText().contains("Showing 21 to 30"));
		hp.logoff();
		Log.endTestCase("verify_storepage_pagination");
	}
	
	
	
}
