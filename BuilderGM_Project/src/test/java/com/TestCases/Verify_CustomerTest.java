package com.TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify_CustomerTest {
	public WebDriver driver;
	
	@BeforeTest
	public void IntialSetup() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://qa-lucee.buildergm.com/");
		WebElement username = driver.findElement(By.xpath("//input[@name='user_name']"));
		username.click();
		username.sendKeys("jithyaj");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.click();
		password.sendKeys("Hyphen123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@id='headerMenu']")).isDisplayed());
		System.out.println("User Logged in");

	}
	
	@Test(enabled=false)
	public void TestAddCustomer() throws InterruptedException {
		
	driver.findElement(By.xpath("//a[@id='topmenu-4']")).click();
	driver.switchTo().frame(driver.findElement(By.id("main-iframe")));
	driver.switchTo().frame(driver.findElement(By.id("frame1")));
	
	driver.findElement(By.xpath("//a[@href='edit_customer.cfm?add_customer=1']")).click();
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame(driver.findElement(By.id("main-iframe")));	
	driver.findElement(By.xpath("//input[@name='short_name']")).sendKeys("shortname1");
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("fullname");
    driver.findElement(By.xpath("//input[@id='l1_state']")).sendKeys("Alaska");	
	WebElement cust_status = driver.findElement(By.xpath("//select[@name='rel_status']"));
	Select s1 = new Select(cust_status);
	s1.selectByValue("3");	
	WebElement cust_type = driver.findElement(By.xpath("//select[@name='cust_sub_type']"));
	Select s2 = new Select(cust_type);
	s2.selectByValue("SUPP");	
	driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys("Address1");
	driver.findElement(By.xpath("//input[@name='city']")).sendKeys("city");
	driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("324324");
	driver.findElement(By.xpath("//input[@name='email_address']")).sendKeys("sample2@gmail.com");	
	driver.findElement(By.xpath("//input[@name='email_address_2']")).sendKeys("sample12@gmail.com");
	driver.findElement(By.xpath("//input[@name='phone_1']")).sendKeys("7894561230");
	driver.findElement(By.xpath("//input[@name='phone_2']")).sendKeys("4561234560");
	driver.findElement(By.xpath("//input[@name='phone_4']")).sendKeys("6549873215");	
	driver.findElement(By.xpath("//input[@name='phone_3']")).sendKeys("2587413698");
	driver.findElement(By.xpath("//textarea[@name='party_notes']")).sendKeys("Notes");	
	driver.findElement(By.xpath("//input[@name='submit_button']")).click();
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame(driver.findElement(By.id("left-iframe")));
	driver.switchTo().frame(driver.findElement(By.id("select-iframe")));
	
//	//Checking if customer is added
	
	WebElement cust_select= driver.findElement(By.xpath("//select[@id='sidebar-select']"));
	Select s3 = new Select(cust_select);
	String selected=s3.getFirstSelectedOption().getText();
	Assert.assertEquals(selected, "shortname1");
	System.out.println("Customer Added");
	}
	
	@Test(enabled=false)
	public void TestEditCustomer()
	{
		driver.findElement(By.xpath("//a[@id='topmenu-4']")).click();
		driver.switchTo().frame(driver.findElement(By.id("left-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("select-iframe")));
		WebElement cust_select= driver.findElement(By.xpath("//select[@id='sidebar-select']"));
		Select s3 = new Select(cust_select);
		s3.selectByVisibleText("shortname1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("main-iframe")));	
		
		WebElement name=driver.findElement(By.xpath("//input[@name='short_name']"));
		name.clear();
		name.sendKeys("shortdisplay");
		WebElement city=driver.findElement(By.xpath("//input[@name='city']"));
		city.clear();
		city.sendKeys("kuwait city");
		driver.findElement(By.xpath("//input[@name='submit_button']")).click();
	    Assert.assertEquals(name.getAttribute("value"), "shortdisplay");
	    Assert.assertEquals(city.getAttribute("value"), "kuwait city");
	    System.out.println("Customer edited");
		
		
	}
	
	@Test(priority=2)
	public void TestDeleteCustomer() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@id='topmenu-4']")).click();
		driver.switchTo().frame(driver.findElement(By.id("left-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("select-iframe")));
		WebElement cust_select= driver.findElement(By.xpath("//select[@id='sidebar-select']"));
		Select s3 = new Select(cust_select);
		s3.selectByVisibleText("shortname1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("main-iframe")));	
		driver.findElement(By.xpath("//input[@name='delete_button']")).click();
		driver.switchTo().alert().accept();
		
		//check deleted elements
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("left-iframe")));
		driver.switchTo().frame(driver.findElement(By.id("select-iframe")));
		WebElement elements = driver.findElement(By.xpath("//select[@id='sidebar-select']"));
		Select select = new Select(elements);
		List<WebElement> allOptions = select.getOptions();
		for(WebElement a:allOptions)
		{		
			if(a.getText().equals("shortname1"))
			{
			Assert.assertSame(a.getText(),"shortname1");
			System.out.println("Customer  not deleted");
			}
			
		}
		System.out.println("Customer deleted");
	}
	
	@AfterTest
	public void Close() {
		//driver.close();
	}

}
