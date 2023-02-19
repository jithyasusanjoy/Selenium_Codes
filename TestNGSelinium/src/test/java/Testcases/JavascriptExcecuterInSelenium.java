package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavascriptExcecuterInSelenium {
	public WebDriver driver;
	@Test
	public void javaexec()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement checkbox =driver.findElement(By.xpath("//input[@id='persistent']"));
	JavascriptExecutor jscript=(JavascriptExecutor)driver;
	jscript.executeScript("arguments[0].click()", checkbox);
	
	
	
	}
}
 