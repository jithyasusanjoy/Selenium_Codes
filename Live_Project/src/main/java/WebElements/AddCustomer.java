package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
WebDriver driver;
	
	@FindBy(xpath="//button[@data-target='#AddCustomer']")
	WebElement Add_Customer;
	
	@FindBy(xpath="//input[@id='CustomerName']")
	WebElement Customer_Name;
	
	@FindBy(xpath="//input[@id='CustomerPhone']")
	WebElement Customer_Phone;
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement Customer_Email;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement Customer_Discount;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement Close_btn1;
	
	
	public AddCustomer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement add_Customer()
	{
		return Add_Customer;
	}
	public WebElement customer_Name()
	{
		return Customer_Name;
	}
	public WebElement customer_Phone()
	{
		return Customer_Phone;
	}
	public WebElement customer_Email()
	{
		return Customer_Email;
	}
	public WebElement customer_Discount()
	{
		return Customer_Discount;
	}
	public WebElement Submit_btn()
	{
		return Submit_btn1;
	}
	public WebElement Close_btn()
	{
		return Close_btn1;
	}
}
