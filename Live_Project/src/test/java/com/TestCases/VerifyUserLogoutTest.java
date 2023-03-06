package com.TestCases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import WebElements.HomePage;
import WebElements.LoginPage;

public class VerifyUserLogoutTest extends BaseClass {
	
	@BeforeTest
	public void launch()
	{
		launchApp();
	}
	
	@Test
	public void user_logout() 
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp= new HomePage(driver);
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
		act.click1(hp.logout(), "Logout done");
		act.explicitWait(driver, lp.login_label(),Duration.ofSeconds(10)); 
		Assert.assertEquals(lp.login_label().getText(),"Login");
		System.out.println("Back to Login page");
	}
	

}
