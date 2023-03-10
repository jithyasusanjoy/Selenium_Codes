package com.TestCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Base.BaseClass.BaseClass;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.project.Utilities.Log;

public class VerifyHomepageTest extends BaseClass {
	
	@BeforeMethod
	public void launch()
	{
		launchApp();
		common_methods();
	}
	
	public void common_methods()
	{
		LoginPage lp=new LoginPage(driver);
		lp.LoginFn(); 	
		HomePage hp =new HomePage(driver);
		Log.info("User logged in");
		Assert.assertEquals(hp.page_heading().getText(),"CHOOSE A STORE");
	}
	
	
	
	@Test(enabled=false)
	public void select_language()
	{
		Log.startTestCase("select_language");
		HomePage hp =new HomePage(driver);
		act.click1(hp.language_dropdown(), "Clicked dropdown");
		act.click1(hp.language(), "Selected Language");	
		Assert.assertTrue(hp.Language_displayed().isDisplayed());
		Log.info("Language Test passed");
		Log.endTestCase("select_language");
	}
	
	@Test(priority=1,enabled=false)
	public void user_name() 
	{
		Log.startTestCase("user_name");
		HomePage hp= new HomePage(driver);	
		Assert.assertEquals(hp.user_name().getText(),"  admin Doe");
		Log.info("Admin user");
		Log.endTestCase("user_name");
		user_logout();
	}
	
	@Test(priority=4,enabled=false)
	public void user_logout() 
	{
		Log.startTestCase("user_logout");
		LoginPage lp=new LoginPage(driver);	
		HomePage hp= new HomePage(driver);
		act.click1(hp.logout(), "Logout done");
		act.explicitWait(driver, lp.login_label(),Duration.ofSeconds(10)); 
		Assert.assertEquals(lp.login_label().getText(),"Login");
		Log.info("Back to Login page");
		Log.endTestCase("user_logout");
	}
	
	@Test(priority=2)
	public void home_menu()
	{
		Log.startTestCase("home_menu");	
		HomePage hp= new HomePage(driver);
		List<String> list1 = new ArrayList<String>();
		List<WebElement> list2 =new ArrayList<WebElement>();
		list2=hp.menu();
		list1.add("POS");
		list1.add("Product");
		list1.add("Stores");
		list1.add("People");
		list1.add("Sales");
		list1.add("Expense");
		list1.add("Categories ");
		list1.add("Setting");
		list1.add("Reports");
		boolean flag=false;
		for (int i = 0; i < list1.size(); i++) 
		{			
			for (WebElement j : list2)
			{			
			 if(list1.get(i).equalsIgnoreCase(j.getText()));
			 flag=true;
			 break;
			}				
		}
		Assert.assertTrue(flag);
		Log.endTestCase("home_menu");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	

}
