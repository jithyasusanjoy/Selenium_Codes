package Testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertInSelenium {
	public WebDriver driver;
	
	@BeforeTest
	public void browserload()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(enabled=false)
	public void handlingalert()
	{
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.findElement(By.id("accept-choices")).click();
		WebElement iframe=driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().accept();
	}
	@Test
	public void windowhandle()
	{
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.linkText("Open a popup window")).click();
		String defaultwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles(); 
		Iterator<String> itr =allwindows.iterator();
		while(itr.hasNext())
		{
			String childwindow =itr.next();
			if(!defaultwindow.equals(childwindow))
			{
				driver.switchTo().window(childwindow);
				System.out.println(driver.switchTo().window(childwindow).getTitle());
			}
		}
		driver.switchTo().window(defaultwindow);
		Assert.assertEquals(true, driver.findElement(By.linkText("Page One")).isDisplayed());
		System.out.println(driver.switchTo().window(defaultwindow).getTitle());
		
		
	
	}
	
}
