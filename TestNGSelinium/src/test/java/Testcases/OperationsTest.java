package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	public void TextboxInput() throws InterruptedException
	{	  
	  driver.findElement(By.partialLinkText("Simple")).click(); 
	  driver.findElement(By.cssSelector("input[id='single-input-field']")).click();
	  driver.findElement(By.cssSelector("input[id='single-input-field']")). sendKeys("Automation using Selenium"); //
	  driver.findElement(By.cssSelector("button[id='button-one']")).click();
	  
	  boolean s=driver.findElement(By.cssSelector("div[id='message-one']")).isDisplayed();
	  Assert.assertEquals(true, s);
	  driver.findElement(By.cssSelector("input[id='single-input-field']")).clear();//clear the input 
	  
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
	  WebElement s=driver.findElement(By.cssSelector("div[id='message-two']"));
	  SoftAssert assertt= new SoftAssert();
	  assertt.assertEquals("Total A + B : 12", s.getText(), "Test pass");
	  System.out.println("Soft assertion Checking");
	 
	  assertt.assertAll();
	  driver.close();
	  
	 }
	
	
	
}
