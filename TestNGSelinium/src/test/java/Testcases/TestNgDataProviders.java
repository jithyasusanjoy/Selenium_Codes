package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviders {
	
	@Test(dataProvider="getlogin")
	public void swaglabs(String username,String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");		
		driver.findElement(By.cssSelector("input[id='user-name']")).click();
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("login-button")).submit();  
	}
	
	@DataProvider
	public Object[][] getlogin()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		data[1][0]="locked_out_user";
		data[1][1]="secret_sauce";
		data[2][0]="problem_user";
		data[2][1]="secret_sauce";
		return data;
		
	}
	
	
	
	
	
	

}
