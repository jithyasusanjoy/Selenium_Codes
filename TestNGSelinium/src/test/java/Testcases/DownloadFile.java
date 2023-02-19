package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadFile {
	
	private static final String FileUtil = null;
	public WebDriver driver;
	@Test
	public void browserload() throws InterruptedException
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://filesamples.com/formats/csv");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(true,driver.findElement(By.xpath("//h1[text()='Sample CSV Files Download']")).isDisplayed());
		System.out.println("site loaded");	
		driver.findElement(By.cssSelector("a[href='/samples/document/csv/sample4.csv'] "));
		
//		Assert.assertTrue(FileUtil.isFileDownloaded("sample", "csv", 5000));
//		System.out.println("File Downloaded");
	
	}
	
	
	
	
}
