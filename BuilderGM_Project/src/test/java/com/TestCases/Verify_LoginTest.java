package com.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify_LoginTest {
	public WebDriver driver;
	
	
	@BeforeTest
	public void IntialSetup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://qa-lucee.buildergm.com/");
	}
	
	@Test(priority=1)
	public void TestValidUsername_InvalidPassword() throws InterruptedException
	{
		
		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.click();
		username.sendKeys("jithyaj");		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.click();
		password.sendKeys("Hyphen@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(true,driver.findElement(By.xpath("//div[contains(text(),'Invalid Login')]")).isDisplayed());
		System.out.println("Invalid Password");
		
	}
	
	@Test(priority=2)
	public void TestInValidUsername_validPassword() throws InterruptedException
	{
		
		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.click();
		username.sendKeys("jithyajith");		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.click();
		password.sendKeys("Hyphen123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(true,driver.findElement(By.xpath("//div[contains(text(),'Invalid Login')]")).isDisplayed());
		System.out.println("Invalid Username");
		
	}
	@Test(priority=3)
	public void TestInValidUsername_InvalidPassword() throws InterruptedException
	{
		
		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.click();
		username.sendKeys("jithya1234");		
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.click();
		password.sendKeys("Hyphen@1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(true,driver.findElement(By.xpath("//div[contains(text(),'Invalid Login')]")).isDisplayed());
		System.out.println("Invalid Username  & Password");
		
	}
	
	@Test(priority=4)
	public void TestValidUsername_ValidPassword() throws InterruptedException
	{
		WebElement username = driver.findElement(By.xpath("//input[@name='user_name']"));
		username.click();
		username.sendKeys("jithyaj");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.click();
		password.sendKeys("Hyphen123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@id='headerMenu']")).isDisplayed());
		System.out.println("User Logged in");
		
	}
	
	@AfterTest
	public void Close()
	{
		driver.close();
	}
	

}
