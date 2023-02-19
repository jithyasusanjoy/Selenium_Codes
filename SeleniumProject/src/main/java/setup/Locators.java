package setup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		
		//css selector
		driver.findElement(By.cssSelector("input[id='user-name']")).click();
		
		//Xpath
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.name("login-button")).submit();     //submit method used
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.linkText("Reset App State")).click();
		
		
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.findElement(By.tagName("button")).click();
		driver.close();
	
	}

}
