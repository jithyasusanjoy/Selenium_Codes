package setup;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.obsqurazone.com/jquery-select.php");
		/*
		 * // Dropdown with select
		 * 
		 * driver.findElement(By.className("select2-selection__rendered")).click();
		 * driver.findElement(By.cssSelector("input[role='searchbox']")).sendKeys("W");
		 * String str = "iowa"; List<WebElement> l =
		 * driver.findElements(By.cssSelector("li[role='option']")); for (WebElement i :
		 * l) { if (i.getText().equalsIgnoreCase(str)) { i.click(); } }
		 */

		// Dropdown with multiple values

		List<String> list2 = new ArrayList<String>();
		List<WebElement> list1 =new ArrayList<WebElement>();
		list2.add("Hawaii");
		list2.add("Washington");

		for (int i = 0; i < list2.size(); i++) 
		{
			driver.findElement(By.cssSelector("span[class ='select2-selection select2-selection--multiple']")).click();
			driver.findElement(By.cssSelector("span[class ='select2-selection select2-selection--multiple']")).sendKeys("W");
			Thread.sleep(2000);

			list1 = driver.findElements(By.cssSelector("li[class='select2-results__option select2-results__option--selectable']"));

			for (WebElement j : list1)
			{
				if (list2.get(i).equalsIgnoreCase(j.getText()))
				{
					j.click();
					break;
				}
			}
		}
		Thread.sleep(5000);
		//deselection
		for (int i = list2.size(); i >0 ; i--) 
		{
			driver.findElement(By.cssSelector("span[class ='select2-selection select2-selection--multiple']")).click();
			List<WebElement> list3 =driver.findElements(By.cssSelector("ul[class='select2-selection__rendered']"));
			Thread.sleep(2000);
			for (WebElement k : list3)
			{
				k.findElement(By.cssSelector("button[class='select2-selection__choice__remove']")).click();
			}
		}
		
		
		
		
	}
}
