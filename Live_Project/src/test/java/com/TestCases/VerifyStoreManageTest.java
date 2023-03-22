package com.TestCases;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;

public class VerifyStoreManageTest extends BaseClass {

	@Test(priority = 1, groups = { "Regression" }, enabled = false)
	public void verify_add_store_zone() throws Exception {
		Log.startTestCase("verify_add_store_zone");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.add_Zone(), "Clicked add zone icon");
		act.type(sm.add_zone_Name(), "South Zone" + ran.nextInt());
		Log.info("Entered zone name");
		act.click1(sm.add_Zone_Submit_btn(), "submitted");
		Assert.assertEquals(sm.Zone_heading().getText(), "Store Zones");
		Log.info("Zone added");
		hp.logoff();
		Log.endTestCase("verify_add_store_zone");
	}

	@Test(priority = 2, enabled = false)
	public void verify_edit_store_zone() throws Exception {
		Log.startTestCase("verify_edit_store_zone");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.edit_Zone(), "Clicked edit icon");
		act.type(sm.edit_Zone_Name(), "South East Zone" + ran.nextInt());
		Log.info("Edited new zone name");
		act.click1(sm.edit_Zone_Submit_btn(), "Submitted");
		Assert.assertEquals(sm.Zone_heading().getText(), "Store Zones");
		Log.info("Zone edited");
		hp.logoff();
		Log.endTestCase("verify_edit_store_zone");
	}

	@Test(priority = 3, enabled = false)
	public void verify_delete_store_zone() {
		Log.startTestCase("verify_delete_store_zone");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.delete_Zone(), "Clicked close icon");
		act.click1(sm.Delete_Zone_confirm(), "delete zone");
		Assert.assertEquals(sm.Zone_heading().getText(), "Store Zones");
		Log.info("Zone deleted");
		hp.logoff();
		Log.endTestCase("verify_delete_store_zone");
	}

	@Test(priority = 4, enabled = false)
	public void verify_add_store_table() throws Exception {
		Log.startTestCase("verify_add_store_table");
		lp.LoginFn();
		sm.common_steps();
		act.click1(sm.add_table(), "Clicked add icon");
		ArrayList<String> exceldata = data.getData("AddTable");
		act.type(sm.Table_Name(), exceldata.get(0));
		Log.info("Entered table name");
		act.selectByValue(sm.Choose_Zone(), exceldata.get(1));
		Log.info("Selected zone");
		act.click1(sm.Submit_btn1(), "submitted");
		Assert.assertEquals(sm.Zone_heading().getText(), "Store Zones");
		Log.info("table added");
		hp.logoff();
		Log.endTestCase("verify_add_store_table");
	}

	@Test(priority = 5, enabled = false)
	public void verify_edit_store_table() throws Exception {
		Log.startTestCase("verify_edit_store_table");
		lp.LoginFn();
		act.click1(hp.stores(), "Clicked");
		Log.info("clicked  store menu");
		act.click1(sp.Manage_Table(), "Clicked manage store icon ");
		act.click1(sm.Table_edit(), "Clicked edit icon");
		act.type(sm.Table_Name(), "Table2" + ran.nextInt());
		Log.info("Edited table name");
		act.click1(sm.Edit_table_Submit_btn(), "Submitted");
		Assert.assertEquals(sm.Zone_heading().getText(), "Store Zones");
		System.out.println("Table edited");
		hp.logoff();
		Log.endTestCase("verify_edit_store_table");
	}

	@Test(priority = 6)
	public void verify_delete_store_table() throws InterruptedException {
		Log.startTestCase("verify_delete_store_table");
		lp.LoginFn();
		Thread.sleep(5000);
		if((hp.menu_icon().isDisplayed())) {
		act.click1(hp.menu_icon(), "clicked icon");	
		}
		Thread.sleep(5000);
		act.click1(hp.stores(), "Store menu Clicked");
		
//		act.click1(sp.Manage_Table(), "Clicked manage store icon ");
//		act.click1(sm.Table_delete(), "Clicked close icon");
//		Log.info("Deleted table");
//		Assert.assertEquals(sm.Zone_heading().getText(),"Store Zones");	
//		System.out.println("Table deleted");
//		hp.logoff();
//		Log.endTestCase("verify_delete_store_table");
	}

}
