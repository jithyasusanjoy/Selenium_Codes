package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwaglabsHomePage {
	WebDriver driver;
	
	By addcart=By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']");
	By cartview=By.cssSelector("a[class='shopping_cart_link']");
	
	
	public SwaglabsHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement addtocart()
	{
		return driver.findElement(addcart);
	}
	public WebElement viewcart()
	{
		return driver.findElement(cartview);
	}
	
	
	
}
