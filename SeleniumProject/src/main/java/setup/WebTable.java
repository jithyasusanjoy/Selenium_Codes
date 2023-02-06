package setup;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/jithya%20susan/Documents/dynamic.html");

		//Finding number of Rows

		List<WebElement> rowsNumber = driver.findElements(By.xpath("//table[@name='Table']//tbody/tr/td[1]"));
		int rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
		
		
		
		/*
		 * System.out.println("Elements in first column are"); for(WebElement
		 * e:rowsNumber) { System.out.println(e.getText()); }
		 */
		
		

		//Finding number of Columns

		List<WebElement> columnsNumber = driver.findElements(By.xpath("//table[@name='Table']//tbody/tr/th"));
		int columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);
		
		
		
		//finding the elements in the first column
		
		String firsthalf="//table[@name='Table']//tbody/tr[";
		String secondhalf ="]/td[1]";
		System.out.println("Elements in first columns are:");
		for(int i=2;i<=rowCount;i++)
		{
			String columnxpath=firsthalf+i+secondhalf;
			WebElement columnelements=driver.findElement(By.xpath(columnxpath));
			System.out.println(columnelements.getText());
			
		//Finding element position
			
			if(columnelements.getText().equalsIgnoreCase("Learn JS"))
			{
				System.out.println("Book Name "+columnelements.getText()+" is found at position "+i);
				break;
			}
			
		 }
		
		//finding the elements in the first row
		String firsthalf1="//table[@name='Table']//tbody/tr[1]/th[";
		String secondhalf1="]";
		System.out.println("Column Names are:");
		for(int i=1;i<=columnCount;i++)
		{
			String rowxpath=firsthalf1+i+secondhalf1;
			WebElement rowelements=driver.findElement(By.xpath(rowxpath));
			System.out.println(rowelements.getText());
		}
		
		//Finding cell value at 4th row and 3rd column

		WebElement cellAddress = driver.findElement(By.xpath("//table[@name='Table']//tbody/tr[4]/td[3]"));
		System.out.println("The Cell Value is : " +cellAddress.getText());
		
		
		
		//finding all elements
		
		List<WebElement> allelements = driver.findElements(By.xpath("//table[contains(@name,'Table')]"));
		for(WebElement a:allelements)
		{
			System.out.println(a.getText());
			
		}
		
		driver.quit();
		
	}
	
}
