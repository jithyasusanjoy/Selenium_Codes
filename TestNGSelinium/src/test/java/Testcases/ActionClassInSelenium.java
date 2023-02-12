package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClassInSelenium {
	public WebDriver driver;

	@BeforeTest
	public void IntialSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(enabled=false)
	public void mouseclick() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.id("user-name"));
		Actions act = new Actions(driver);
		act.contextClick(username).perform();
		act.click(username);
		Thread.sleep(3000);
	}

	@Test(enabled=false)
	public void mousedoubleclick() throws InterruptedException {

		driver.get("https://seleniumbase.io/w3schools/double_click");
		WebElement ifram = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(ifram);
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Double')]"));
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		
	}

	@Test(enabled=false)
	public void draganddrop() throws InterruptedException {
		
		driver.get("https://selenium.obsqurazone.com/drag-drop.php");
		Thread.sleep(5000);
		
		WebElement fromElement = driver.findElement(By.xpath("//span[text()='Draggable n°2']"));
		WebElement toElement = driver.findElement(By.xpath("//div[@id='mydropzone']"));

		Actions act = new Actions(driver);
	//	act.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
		Thread.sleep(5000);
		act.dragAndDrop(fromElement, toElement).build().perform();
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@id='mylist'])")).isDisplayed());
		System.out.println("Drag and drop done");	
	}
	
	
	@Test
	public void mousehover() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(3000);
		
		WebElement menuOption1 = driver.findElement(By.xpath("//div[text()='Electronics']"));
		actions.moveToElement(menuOption1).perform();
		Thread.sleep(2000);
		
		WebElement menuOption2 = driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"));
		actions.moveToElement(menuOption2).perform();
		Thread.sleep(2000);
		
		WebElement menuOption3 = driver.findElement(By.xpath("//a[text()='DSLR & Mirrorless']"));
		actions.moveToElement(menuOption3).perform();
		Thread.sleep(2000);
		
		menuOption3.click();
		Thread.sleep(2000);
		Assert.assertEquals(true, driver.findElement(By.xpath("//h1[text()='DSLR & Mirrorless']")).isDisplayed());
		System.out.println("Success");
   	
	}
	

	@AfterTest
	public void browserclose() {
		 driver.quit();
	}

}
