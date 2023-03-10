package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClassInSelenium {
	public WebDriver driver;
	

	@BeforeTest(groups= {"smoke"})
	public void IntialSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(groups= {"smoke"})
	public void mouseclick() throws InterruptedException {
		
		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.id("user-name"));
		Actions act = new Actions(driver);
		act.contextClick(username).perform();
		act.click(username);
	
	}

	@Test(groups= {"smoke"})
	public void mousedoubleclick() throws InterruptedException {

		driver.get("https://seleniumbase.io/w3schools/double_click");
		WebElement ifram = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(ifram);
		
		WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Double')]"));
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	@Test(groups= {"smoke"},priority=1)
	public void draganddrop() throws InterruptedException {

		
		driver.get("https://demo.guru99.com/test/drag_drop.html");	
		WebElement iframe=driver.findElement(By.id("gdpr-consent-notice"));
		driver.switchTo().frame(iframe);
		
		driver.findElement(By.xpath("//span[text()='Accept All']")).click(); 
		WebElement fromElement =driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
		WebElement toElement =driver.findElement(By.xpath("//ol[@id='amt7']"));
		
		
		Actions act = new Actions(driver);
		act.dragAndDrop(fromElement,toElement).perform();
		
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//td[contains(text(),'Debit')]")).isDisplayed());
		System.out.println("Drag and drop done");	
	}

	@Test(groups={"smoke"})
	public void mousehover() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
	
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		
		WebElement menuOption1 = driver.findElement(By.xpath("//div[text()='Electronics']"));
		actions.moveToElement(menuOption1).perform();
		
		
		WebElement menuOption2 = driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"));
		actions.moveToElement(menuOption2).perform();
		
		
		WebElement menuOption3 = driver.findElement(By.xpath("//a[text()='DSLR & Mirrorless']"));
		actions.moveToElement(menuOption3).perform();
	
		
		menuOption3.click();
		
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//h1[text()='DSLR & Mirrorless']")).isDisplayed());
		System.out.println("Success");
   	
	}
	

	@AfterTest(groups= {"smoke"})
	public void browserclose() {
	 driver.quit();
	}

}
