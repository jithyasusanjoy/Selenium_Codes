package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileSendKey {
	
	public WebDriver driver;
	@BeforeTest
	public void browserload() throws InterruptedException
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(true,driver.findElement(By.xpath("//h1[text()='jQuery File Upload Demo']")).isDisplayed());
		System.out.println("Browser loaded");		
	}
	
	
	  //file upload using send keys
	  
	  @Test public void fileUploadUsingSendKey() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\jithya susan\\Downloads\\qa-lucee_bugs\\d1.png");
	  driver.findElement(By.xpath("(//button[@class='btn btn-primary start'])[2]")).click();
	 
	  Assert.assertEquals(true,driver.findElement(By.cssSelector("button[data-type='DELETE']")).isDisplayed());
	  System.out.println("File uploaded successfully");
	 
	  }
	 
	  
	  @AfterTest
	  public void BrowserClose()
	  {
		  driver.quit();
	  }


}
