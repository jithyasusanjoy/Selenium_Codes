package Testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(true,driver.findElement(By.xpath("//h1[@class='registration-heading tc']")).isDisplayed());
		System.out.println("Browser loaded");		
	}
	
	//file upload using Robot class
	  
	  @Test public void fileUploadUsingRobotClass() throws InterruptedException, AWTException
	
	  {
		  driver.findElement(By.xpath("//*[text()='Choose CV']")).click();
		 
		  Robot rb=new Robot();
		  StringSelection str = new StringSelection("C:\\Users\\jithya susan\\Downloads\\Timeline_page1.pdf");
		 
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		  Thread.sleep(3000);
		  rb.keyPress(KeyEvent.VK_CONTROL);
		  rb.keyPress(KeyEvent.VK_V);
		  rb.keyRelease(KeyEvent.VK_CONTROL);
		  rb.keyRelease(KeyEvent.VK_V);
		  
		  rb.keyPress(KeyEvent.VK_ENTER);
		  rb.keyRelease(KeyEvent.VK_ENTER);
	
		  Assert.assertEquals(true,driver.findElement(By.xpath("//a[text()='Remove']")).isDisplayed());
		  System.out.println("File uploaded successfully");
		 
	
	  }
	  
	  @AfterTest
	  public void BrowserClose()
	  {
		  driver.quit();
	  }
	
	
}
