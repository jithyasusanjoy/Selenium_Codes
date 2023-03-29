package com.TestCases;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.project.Utilities.Log;
import com.project.Utilities.ExcelRead;

public class VerifyUserLoginTest extends BaseClass {


	@Test(priority = 4,groups = { "Regression" })
	public void verify_valid_User_Login() {
		Log.startTestCase("validUserLogin");
		lp.LoginFn();
		Assert.assertEquals(hp.page_heading().getText(), "CHOOSE A STORE");
		Log.info("User logged in");
		hp.logoff();
		Log.endTestCase("validUserLogin");
		
	}

	@Test(dataProvider = "getlogin", priority = 3)
	public void verify_valid_User_invalid_Password_login(String username, String password) {

		Log.startTestCase("valid_User_invalid_Pass");
		act.type(lp.uname(), username);
		Log.info("User entered valid username");
		act.type(lp.pwd(), password);
		Log.info("User entered invalid password");
		act.click1(lp.lbutton(), "Clicking On Login Button");
		Assert.assertEquals(lp.login_label().getText(), "Login");
		Log.info("Unable to Login");
		Log.endTestCase("valid_User_invalid_Pass");
	}

	@DataProvider
	public Object[][] getlogin()throws Exception {
		Object[][] data1 = new Object[2][2];
		ExcelRead data = new ExcelRead();
		ArrayList<String> exceldata = data.getData("Invalid");
		data1[0][0] = exceldata.get(0);
		data1[0][1] = exceldata.get(1);
		data1[1][0] = exceldata.get(2);
		data1[1][1] = exceldata.get(3);
		return data1;
	}

	@Test(priority = 2)
	public void verify_invalid_User_valid_password_login() throws Exception {

		Log.startTestCase("invalid_User_valid_pass");
		ArrayList<String> exceldata = data.getData("Invalid");
		act.type(lp.uname(), exceldata.get(0));
		Log.info("User entered invalid username");
		act.type(lp.pwd(), exceldata.get(1));
		Log.info("User entered valid password");
		act.click1(lp.lbutton(), "Clicked Login Button");
		Assert.assertEquals(lp.login_label().getText(), "Login");
		System.out.println("Unable to Login");
		Log.endTestCase("invalid_User_valid_pass");
	}

	@Test(priority = 1)
	public void verify_invalid_User_invalid_password_login() throws Exception {
		Log.startTestCase("invalid_User_invalid_pass");
		ArrayList<String> exceldata = data.getData("Login1");
		act.type(lp.uname(), exceldata.get(0));
		Log.info("User entered invalid username");
		act.type(lp.pwd(), exceldata.get(1));
		Log.info("User entered invalid password");
		act.click1(lp.lbutton(), "Clicked Login Button");
		Assert.assertEquals(lp.login_label().getText(), "Login");
		Log.info("Unable to Login");
		Log.endTestCase("invalid_User_invalid_pass");
	}
	

}
