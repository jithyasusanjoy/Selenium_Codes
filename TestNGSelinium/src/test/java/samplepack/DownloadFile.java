package samplepack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadFile {
	
	public WebDriver driver;
	@Test
	public void browserload() throws InterruptedException
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://filesamples.com/formats/csv");
		Thread.sleep(3000);
		Assert.assertEquals(true,driver.findElement(By.xpath("//h1[text()='Sample CSV Files Download']")).isDisplayed());
		System.out.println("site loaded");	
		driver.findElement(By.cssSelector("a[href='/samples/document/csv/sample4.csv'] "));
		Thread.sleep(1000);
//		Assert.assertEquals(true,driver.findElement(By.xpath("//embed[@type='application/pdf']")).);
//		System.out.println("File Downloaded");
	
	}
	
	
	
	
}
