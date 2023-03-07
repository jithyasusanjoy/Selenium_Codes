package com.TestCases;
import java.time.Duration;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.Log;

public class VerifyUserLoginTest extends BaseClass {
	
	
	@BeforeTest
	public void launch()
	{
		launchApp();
		
	}
	@Test(priority=4)
	public void validUserLogin()
	{	
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 
		HomePage hp=new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		System.out.println("Logged in");
		
	}
	
	
	@Test(dataProvider="getlogin",priority=3)
	public void validUserinvalidPass(String username,String password)
	{
		LoginPage lp=new LoginPage(driver);
		act.type(lp.uname(),username);
		act.type(lp.pwd(),password);
		act.click1(lp.lbutton(),"Clicking On Login Button");	
		act.explicitWait(driver, lp.login_label(),Duration.ofSeconds(10)); 
		Assert.assertEquals(lp.login_label().getText(),"Login");
		System.out.println("Unable to Login");
	}
	
	@DataProvider
	public Object[][] getlogin()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Admin";
		data[0][1]="paswd";
		data[1][0]="Admin";
		data[1][1]="paswdd";
		return data;		
	}
	
	  @Test(priority=2)
	  public void invalid_User_valid_pass() 
	  {
		  Log.startTestCase("invalid_User_valid_pass");
	  LoginPage lp=new LoginPage(driver);
	  Log.info("user is going to enter username");
	  act.type(lp.uname(),"aaammi"); 
	  Log.info("user is going to enter password");
	  act.type(lp.pwd(),"Password");
	  act.click1(lp.lbutton(),"Clicking On Login Button");
	  act.explicitWait(driver, lp.login_label(),Duration.ofSeconds(10));  
	  Assert.assertEquals(lp.login_label().getText(),"Login");
	  System.out.println("Unable to Login");
	  Log.endTestCase("invalid_User_valid_pass"); 
	  }
	  
	  @Test(priority=1)
	  public void invalid_User_invalid_pass() throws Exception 
	  {
	  LoginPage lp=new LoginPage(driver);
	  ExcelRead data= new ExcelRead();
	  ArrayList<String> exceldata=data.getData("VerifyUserLoginTest");
	  act.type(lp.uname(),exceldata.get(0));
	  act.type(lp.pwd(),exceldata.get(1));
	  act.click1(lp.lbutton(),"Clicking On Login Button"); 
	  act.explicitWait(driver, lp.login_label(),Duration.ofSeconds(10)); 
	  Assert.assertEquals(lp.login_label().getText(),"Login");
	  System.out.println("Unable to Login");
	  }
	 
	
	
}
