package pomtestcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Package1.SwaglabsHomePage;
import Package1.SwaglabsLoginPage;

public class LoginTest {
	public WebDriver driver;
	
	@Test(priority=1)
	public void Login()
	{
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.saucedemo.com/");
	SwaglabsLoginPage lp=new SwaglabsLoginPage(driver);
	lp.Uname().click();
	lp.Uname().sendKeys("standard_user");
	lp.pwd().click();
	lp.pwd().sendKeys("secret_sauce");
	lp.Lbutton().click();
	}
	
	@Test(priority=2)
	public void Home()
	{
		SwaglabsHomePage hp=new SwaglabsHomePage(driver);
		hp.addtocart().click();
		hp.viewcart().click();
		
	}

	
	
}
