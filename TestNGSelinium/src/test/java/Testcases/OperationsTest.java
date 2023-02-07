package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OperationsTest {
	
	public WebDriver driver;
	
	@BeforeTest
	public void IntialSetup()
	{
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	}
	
	@Test(priority=1)
	public void TextboxInput() throws InterruptedException
	{	  
	  driver.findElement(By.partialLinkText("Simple")).click(); 
	  driver.findElement(By.cssSelector("input[id='single-input-field']")).click();
	  driver.findElement(By.cssSelector("input[id='single-input-field']")). sendKeys("Automation using Selenium"); //
	  driver.findElement(By.cssSelector("button[id='button-one']")).click();
	  Thread.sleep(2000); 
	  boolean s=driver.findElement(By.cssSelector("div[id='message-one']")).isDisplayed();
	  Assert.assertEquals(true, s);
	  driver.findElement(By.cssSelector("input[id='single-input-field']")).clear();//clear the input 
	  Thread.sleep(3000); 
	}
	
	 @Test(priority=2)
	 public void TextboxTwoInput() throws InterruptedException
	 {	  
	 driver.findElement(By.cssSelector("input[id='single-input-field']")).click();
	  driver.findElement(By.cssSelector("input[id='value-a']")).sendKeys("10");
	  driver.findElement(By.cssSelector("input[id='value-a']")).click(); 
	  driver.findElement(By.cssSelector("input[id='value-b']")).sendKeys("2"); 
	  driver.findElement(By.cssSelector("input[id='value-b']")).click(); 
	  driver.findElement(By.cssSelector("button[id='button-two']")).click(); 
	  SoftAssert assertt= new SoftAssert();
	  assertt.assertEquals(10, 12, "Test pass");
	  System.out.println("Soft assertion Checking");
	  Thread.sleep(3000);
	  assertt.assertAll();
	  driver.close();
	  
	 }
	
	
	
}
