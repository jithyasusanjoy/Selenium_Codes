package Testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitFluentWait {
	
	public WebDriver driver;
	

	@BeforeTest
	public void IntialSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://demo.guru99.com/test/guru99home/");
		WebElement iframe=driver.findElement(By.id("gdpr-consent-notice"));
		driver.switchTo().frame(iframe);		
		driver.findElement(By.xpath("//span[text()='Accept All']")).click(); 
	}
	
	@Test
	public void waitexplicit() throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon-coffee']")));
		element.click();
		
	}
	
	@Test
	public void waitfluent() 
	{
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5)) 			
				  .ignoring(NoSuchElementException.class);
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-lasso-id='182896']")));
		element.click();
	}
	
}
