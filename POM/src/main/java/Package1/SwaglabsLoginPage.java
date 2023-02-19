package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwaglabsLoginPage {
	
	WebDriver driver;
	
	By username=By.id("user-name");
	By password=By.id("password");
	By loginbutton=By.id("login-button");
	
	public SwaglabsLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Uname()
	{
		return driver.findElement(username);
	}
	public WebElement pwd()
	{
		return driver.findElement(password);
	}
	public WebElement Lbutton()
	{
		return driver.findElement(loginbutton);
	}
	
}
