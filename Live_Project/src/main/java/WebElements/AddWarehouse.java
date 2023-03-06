package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddWarehouse {
WebDriver driver;
	
	@FindBy(xpath="//a[@href='#warehouses']")
	WebElement Warehouse_tab;
	
	@FindBy(xpath="//button[@data-target='#AddWarehouse']")
	WebElement Add_Warehouse;
	
	@FindBy(xpath="//input[@id='WarehouseName']")
	WebElement WarehouseName;
	
	@FindBy(xpath="//input[@id='Warehouse Phone']")
	WebElement Warehouse_Phone;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='Adresse']")
	WebElement Address;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	WebElement Submit_btn3;
	
	@FindBy(xpath="(//button[text()='Close'])[2]")
	WebElement Close_btn2;
	
	
	
	public AddWarehouse(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement Warehouse_tab()
	{
		return Warehouse_tab;
	}
	public WebElement add_Warehouse()
	{
		return Add_Warehouse;
	}
	public WebElement warehouseName()
	{
		return WarehouseName;
	}
	public WebElement warehouse_Phone()
	{
		return Warehouse_Phone;
	}
	public WebElement address()
	{
		return Address;
	}
	public WebElement Submit_btn3()
	{
		return Submit_btn3;
	}
	public WebElement Close_btn2()
	{
		return Close_btn2;
	}
	public WebElement email()
	{
		return email;
	}
	
}
