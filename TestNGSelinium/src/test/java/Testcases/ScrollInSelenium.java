package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

@SuppressWarnings("unused")
public class ScrollInSelenium {
	public WebDriver driver;
	 
	
	
	@BeforeTest
	public void IntialSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	@Test()
	public void javascriptpageScroll() throws InterruptedException
	{
		WebElement element=driver.findElement(By.xpath("//h2[text()='Getting Started']"));		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//1. Scrolling to page(x,y)
		js.executeScript("window.scrollTo(0,1000)");
		
		
		//2. Scrolling to page bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		
		//3. Scrolling to particular element
		js.executeScript("arguments[0].scrollIntoView();", element);
	
		}
		
	
		@Test(enabled=true)
		public void actionclasspageScroll() throws InterruptedException
		{	
		  Actions act =new Actions(driver);
		  WebElement element=driver.findElement(By.xpath("//h2[text()='Getting Started']"));
		 
		  act.scrollByAmount(0,500);
		  act.perform();
		 
		 	  
		  act.scrollToElement(element);
		  act.perform();
		 
		  
		  WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
		  act.scrollFromOrigin(scrollOrigin, 0, 1000);
		  act.perform();
		 
		  
		}
		
		@AfterTest
		public void browserclose() {
			driver.quit();
		}
}
