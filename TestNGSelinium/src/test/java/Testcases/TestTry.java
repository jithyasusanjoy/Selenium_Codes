package Testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(pack2.ListenerTest.class)
public class TestTry {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	

  @Test(retryAnalyzer=RetryAnalyzer.class)

  public void testFail() {

	  driver.get("https://www.daraz.lk/");
		
		driver.findElement(By.id("q")).click();
		driver.findElement(By.id("q")).clear();
		driver.findElement(By.id("q")).sendKeys("mobile");
		driver.findElement(By.xpath("//div[@id='topActionHeader']/div/div[2]/div/div[2]/form/div/div[2]/button")).click();

		Assert.assertTrue(false);

   }
  @AfterTest
  public void close() {
		driver.quit();
  }

}
