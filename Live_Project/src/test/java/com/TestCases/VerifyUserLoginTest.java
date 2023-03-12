package com.TestCases;
import java.time.Duration;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

public class VerifyUserLoginTest extends BaseClass {

	@BeforeMethod(groups = { "Regression" })
	public void methods() {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		data = new ExcelRead();
	}

	@Test(priority = 4,groups = { "Regression" })
	public void verify_valid_User_Login() {
		Log.startTestCase("validUserLogin");
		lp.LoginFn();
		Assert.assertEquals(hp.page_heading().getText(), "CHOOSE A STORE");
		Log.info("User logged in");
		Log.endTestCase("validUserLogin");
		hp.logoff();
	}

	@Test(dataProvider = "getlogin", priority = 3,groups = { "Regression" })
	public void verify_valid_User_invalid_Password_login(String username, String password) {

		Log.startTestCase("valid_User_invalid_Pass");
		act.type(lp.uname(), username);
		Log.info("User entered valid username");
		act.type(lp.pwd(), password);
		Log.info("User entered invalid password");
		act.click1(lp.lbutton(), "Clicking On Login Button");
		act.explicitWait(driver, lp.login_label(), Duration.ofSeconds(10));
		Assert.assertEquals(lp.login_label().getText(), "Login");
		Log.info("Unable to Login");
		Log.endTestCase("valid_User_invalid_Pass");
	}

	@DataProvider
	public Object[][] getlogin() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Admin";
		data[0][1] = "paswd";
		data[1][0] = "Admin";
		data[1][1] = "paswdd";
		return data;
	}

	@Test(priority = 2,groups = { "Regression" })
	public void verify_invalid_User_valid_password_login() throws Exception {

		Log.startTestCase("invalid_User_valid_pass");
		ArrayList<String> exceldata = data.getData("Invalid");
		act.type(lp.uname(), exceldata.get(0));
		Log.info("User entered invalid username");
		act.type(lp.pwd(), exceldata.get(1));
		Log.info("User entered valid password");
		act.click1(lp.lbutton(), "Clicked Login Button");
		act.explicitWait(driver, lp.login_label(), Duration.ofSeconds(10));
		Assert.assertEquals(lp.login_label().getText(), "Login");
		System.out.println("Unable to Login");
		Log.endTestCase("invalid_User_valid_pass");

	}

	@Test(priority = 1,groups = { "Regression" })
	public void verify_invalid_User_invalid_password_login() throws Exception {
		Log.startTestCase("invalid_User_invalid_pass");
		ArrayList<String> exceldata = data.getData("Login1");
		act.type(lp.uname(), exceldata.get(0));
		Log.info("User entered invalid username");
		act.type(lp.pwd(), exceldata.get(1));
		Log.info("User entered invalid password");
		act.click1(lp.lbutton(), "Clicked Login Button");
		act.explicitWait(driver, lp.login_label(), Duration.ofSeconds(10));
		Assert.assertEquals(lp.login_label().getText(), "Login");
		Log.info("Unable to Login");
		Log.endTestCase("invalid_User_invalid_pass");
	}
	

}
