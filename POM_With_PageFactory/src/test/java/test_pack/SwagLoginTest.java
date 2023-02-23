package test_pack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import elements_pack.SwagLogin;

public class SwagLoginTest {
	public WebDriver driver;

	@Test
	public void Login()
	{
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.saucedemo.com/");
	SwagLogin lp=new SwagLogin(driver);
	lp.uname().click();
	lp.uname().sendKeys("standard_user");
	lp.pwd().click();
	lp.pwd().sendKeys("secret_sauce");
	lp.lbutton().click();
}
}