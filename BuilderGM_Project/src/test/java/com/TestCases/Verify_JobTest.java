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

public class Verify_JobTest {
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
		Thread.sleep(4000);
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@id='headerMenu']")).isDisplayed());
		System.out.println("User Logged in");

	}

	@Test(priority=1)
	public void TestAddJob() throws InterruptedException {

		WebElement frame = driver.findElement(By.id("left-iframe"));
		driver.switchTo().frame(frame);
		WebElement addjob = driver.findElement(By.xpath("//a[@href='add_job_pre.cfm']"));
		addjob.click();
		
		driver.switchTo().defaultContent();
		WebElement frame1 = driver.findElement(By.id("main-iframe"));
		driver.switchTo().frame(frame1);
		WebElement select_cust = driver.findElement(By.xpath("//select[@name='customer_id']"));
		Select s1 = new Select(select_cust);
		s1.selectByValue("-364378");
		WebElement cont_btn=driver.findElement(By.xpath("//input[@type='submit']"));
		cont_btn.click();
		
		
		WebElement Jobname=driver.findElement(By.xpath("//input[@name='job_name']"));
		Jobname.sendKeys("Automation1");
		WebElement description=driver.findElement(By.xpath("//textarea[@name='job_notes']"));
		description.sendKeys("Notes");
		WebElement address=driver.findElement(By.xpath("//input[@name='address_1']"));
		address.sendKeys("Address1");
		WebElement select_state = driver.findElement(By.xpath("//select[@name='z_state']"));
		Select s2 = new Select(select_state);
		s2.selectByValue("CA");
		WebElement city=driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Automation_city");
		WebElement zip=driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("123456");
		WebElement comp_date=driver.findElement(By.xpath("//input[@id='complete_date']"));
		comp_date.sendKeys("13/09/2023");
		WebElement cont_btn1=driver.findElement(By.xpath("//input[@type='submit']"));
		cont_btn1.click();
		
		
		WebElement markup=driver.findElement(By.xpath("//input[@name='shared_markup_percent']"));
		markup.clear();
		markup.sendKeys("5");
		WebElement overhead=driver.findElement(By.xpath("//input[@name='shared_overhead_percent']"));
		overhead.clear();
		overhead.sendKeys("5");
		WebElement cont_btn3=driver.findElement(By.xpath("//input[@type='submit']"));
		cont_btn3.click();

		WebElement frame2 = driver.findElement(By.id("iframe1"));
		driver.switchTo().frame(frame2);	
		WebElement template=driver.findElement(By.xpath("//a[contains(text(),'Residential Master')]"));
		template.click();
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1);
		WebElement frame3= driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame3);	
		WebElement finish_btn=driver.findElement(By.xpath("//input[@value='Finish']"));
		finish_btn.click();
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1);
		WebElement frame4 = driver.findElement(By.id("right1"));
		driver.switchTo().frame(frame4);
		WebElement frame5= driver.findElement(By.id("frameA"));
		driver.switchTo().frame(frame5);		
		Assert.assertEquals(true,driver.findElement(By.xpath("//td[contains(text(),'Automation1')]")).isDisplayed());
	    System.out.println("Job Added");

	  
	}
	
	@Test(priority=2)
	public void TestEditJob() throws InterruptedException {
		
		WebElement frame1 = driver.findElement(By.id("main-iframe"));
		driver.switchTo().frame(frame1);
		WebElement frame3= driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame3);	
		WebElement job_name=driver.findElement(By.xpath("//a[contains(text(),'Automation123')]"));
		job_name.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1);
		WebElement frame2= driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame2);
		WebElement editjobinfo=driver.findElement(By.xpath("//a[@href='edit_job.cfm']"));
		editjobinfo.click();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1);
		WebElement frame4= driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame4);
		WebElement edit_name=driver.findElement(By.xpath("//input[@name='job_name']"));
		edit_name.clear();
		edit_name.sendKeys("Auto123");
		WebElement save=driver.findElement(By.xpath("//input[@name='save_button']"));
		save.click();
		
		
		driver.switchTo().defaultContent();
		WebElement ret_main= driver.findElement(By.id("main-iframe"));
		driver.switchTo().frame(ret_main);
		WebElement ret_frame1= driver.findElement(By.id("frame1"));
		driver.switchTo().frame(ret_frame1);
		WebElement returnbtn=driver.findElement(By.xpath("//a[@href='job_info.cfm?mode=job']"));
		returnbtn.click();
		
		driver.switchTo().defaultContent();
		WebElement job_infomain = driver.findElement(By.id("main-iframe"));
		driver.switchTo().frame(job_infomain);
		WebElement job_infone= driver.findElement(By.id("frame1"));
		driver.switchTo().frame(job_infone);
		
		WebElement viewJob=driver.findElement(By.xpath("//a[@href='list_jobs.cfm']"));
		viewJob.click();
		Thread.sleep(6000);
		
		
		driver.switchTo().defaultContent();
		WebElement frame6 = driver.findElement(By.id("main-iframe"));
		driver.switchTo().frame(frame6);
		WebElement frame5= driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame5);
		WebElement job_name1=driver.findElement(By.xpath("//a[contains(text(),'Auto123')]"));
		String expected=job_name1.getText();
		Assert.assertEquals("Auto123",expected);
	    System.out.println("Job Edited");
	    Thread.sleep(6000);
		
	}
	
	@Test(priority=3)
	public void TestDeleteJob() throws InterruptedException {
		
		WebElement frame1 = driver.findElement(By.id("main-iframe"));
		driver.switchTo().frame(frame1);
		WebElement frame3= driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame3);	
		WebElement job_name=driver.findElement(By.xpath("//a[contains(text(),'Automation123')]"));
		job_name.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1);
		WebElement frame2= driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame2);
		WebElement editjobinfo=driver.findElement(By.xpath("//a[@href='edit_job.cfm']"));
		editjobinfo.click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame1);
		WebElement frame4= driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame4);
		WebElement delete=driver.findElement(By.xpath("//input[@name='delete_button']"));
		delete.click();
		WebElement delete1=driver.findElement(By.xpath("//input[@value='Yes, Delete This Job']"));
		delete1.click();
		WebElement delete2=driver.findElement(By.xpath("//input[@value='YES, Delete This Job']"));
		delete2.click();
		
		driver.switchTo().defaultContent();
		WebElement frame5 = driver.findElement(By.id("main-iframe"));
		driver.switchTo().frame(frame5);
		WebElement frame6= driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame6);	
		
		//Checking if job is deleted
		List<WebElement> rowsNumber = driver.findElements(By.xpath("//table[contains(@class,'table table-hover table-sm tableData')]//tbody/tr/td[1]"));
		int rowCount = rowsNumber.size();
		String firsthalf="//table[contains(@class,'table table-hover table-sm tableData')]//tbody/tr[";
		String secondhalf ="]/td[2]";
		for(int i=1;i<=rowCount;i++)
		{
			String columnxpath=firsthalf+i+secondhalf;
			WebElement columnelements=driver.findElement(By.xpath(columnxpath));
		
								
			if(columnelements.getText().equalsIgnoreCase("Automation123"))
			{								
				System.out.println("Job not deleted");
				break;
			}
		}
		System.out.println("Job deleted");
		
	}
	

	@AfterTest
	public void Close() {
		driver.close();
	}

}
