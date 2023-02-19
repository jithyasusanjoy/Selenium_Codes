package Testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicWebTable {
	public WebDriver driver;
	public int rowCount;
	public int columnCount;
	public Boolean status;
	
	@BeforeTest
	public void browserload()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/jithya%20susan/Documents/dynamic.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void findrowno()
	{
		List<WebElement> rowsNumber = driver.findElements(By.xpath("//table[@name='Table']//tbody/tr/td[1]"));
		rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
		Assert.assertNotNull(rowCount);
		System.out.println("Row is not null");
	}
	
	@Test
	public void findcolumnno()
	{
		List<WebElement> columnsNumber = driver.findElements(By.xpath("//table[@name='Table']//tbody/tr/th"));
		columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);
		Assert.assertNotNull(columnCount);
		System.out.println("column is not null");
	}
	
	
	@Test(priority=1)
	public void firstcolumnelements()
	{
	String firsthalf="//table[@name='Table']//tbody/tr[";
	String secondhalf ="]/td[1]";
	System.out.println("Elements in first columns are:");
	for(int i=2;i<=rowCount;i++)
	{
		String columnxpath=firsthalf+i+secondhalf;
		WebElement columnelements=driver.findElement(By.xpath(columnxpath));
		System.out.println(columnelements.getText());
		if(columnelements.getText().equalsIgnoreCase("Master In Java"))
		{					
			Assert.assertSame((i-1), 5);
			System.out.println("Book Name: "+columnelements.getText()+" is found at position "+(i-1));
			break;
		}
		
	}
	}
	
	@Test(priority=2)
	public void firstrowelements()
	{
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("BookName");
		list1.add("Author");
		list1.add("Subject");
		list1.add("Price");
		
		String firsthalf1="//table[@name='Table']//tbody/tr[1]/th[";
		String secondhalf1="]";
		System.out.println("Column Names are:");
		for(int i=1;i<=columnCount;i++)
		{
			String rowxpath=firsthalf1+i+secondhalf1;
			WebElement rowelements=driver.findElement(By.xpath(rowxpath));
			System.out.println(rowelements.getText());
			list2.add(rowelements.getText());
		}
		Assert.assertEquals(list1, list2);
		System.out.println("All columns are displayed");
	
	}
	
	@Test(priority=3)
	public void findoneelement()
	{
	WebElement cellAddress = driver.findElement(By.xpath("//table[@name='Table']//tbody/tr[4]/td[3]"));
	Assert.assertEquals(cellAddress.getText(),"Javascript");
	System.out.println("The Cell Value is : " +cellAddress.getText());
	}
	
	@Test(priority=4)
	public void findallelement()
	{
	List<WebElement> allelements = driver.findElements(By.xpath("//table[contains(@name,'Table')]//td"));
	int size=allelements.size();
	Assert.assertEquals(size, 22);
	for(WebElement a:allelements)
	{
		System.out.println(a.getText());
		
	}
	}
	
	@AfterTest
	public void browserclose()
	{
		driver.quit();
	}

}
