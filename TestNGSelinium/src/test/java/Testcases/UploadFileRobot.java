package Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileRobot {
	public WebDriver driver;
	@BeforeTest
	public void browserload() throws InterruptedException
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://my.monsterindia.com/create_account.html");
		Thread.sleep(3000);
		Assert.assertEquals(true,driver.findElement(By.xpath("//h1[@class='registration-heading tc']")).isDisplayed());
		System.out.println("Browser loaded");		
	}
	
	//file upload using Robot class
	  
	  @Test public void fileUploadUsingRobotClass() throws InterruptedException, AWTException
	
	  {
		  driver.findElement(By.xpath("//*[text()='Choose CV']")).click();
		  Thread.sleep(3000);
		  Robot rb=new Robot();
		  StringSelection str = new StringSelection("C:\\Users\\jithya susan\\Downloads\\Timeline_page1.pdf");
		  Thread.sleep(3000);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		  rb.keyPress(KeyEvent.VK_CONTROL);
		  rb.keyPress(KeyEvent.VK_V);
		  Thread.sleep(3000);
		  rb.keyRelease(KeyEvent.VK_CONTROL);
		  rb.keyRelease(KeyEvent.VK_V);
		  Thread.sleep(3000);
		  rb.keyPress(KeyEvent.VK_ENTER);
		  rb.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(3000);
		  Assert.assertEquals(true,driver.findElement(By.xpath("//a[text()='Remove']")).isDisplayed());
		  System.out.println("File uploaded successfully");
		  Thread.sleep(3000);
	
	  }
	  
	  @AfterTest
	  public void BrowserClose()
	  {
		  driver.quit();
	  }
	
	
}
