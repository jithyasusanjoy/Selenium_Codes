package samplepack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	  driver.findElement(By.cssSelector("input[id='single-input-field']")).clear();//clear the input 
	  Thread.sleep(3000); 
	}
	
	
}
