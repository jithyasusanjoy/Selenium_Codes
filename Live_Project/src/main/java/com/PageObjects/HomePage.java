package com.PageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.BaseClass.BaseClass;

public class HomePage extends BaseClass{
	
	
	@FindBy(xpath="//h1[@class='text-center choose_store']")
	private WebElement Heading;
	
	@FindBy(xpath="//span[@class='hidden-xs']")
	private WebElement user_name;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']//img[@src='https://qalegend.com/restaurant/assets/img/flags/en.png']")
	private WebElement Language_dropdown;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/dashboard/change/english']")
	private WebElement Language;
		
	@FindBy(xpath="//img[@src='https://qalegend.com/restaurant/assets/img/flags/en.png']")
	private WebElement Language_displayed;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/products']")
	private WebElement Products;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/stores']")
	private WebElement Stores;
	
	@FindBy(xpath="//span[text()='People']")
	private WebElement People ;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/waiters']")
	private WebElement Waiters;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/customers']")
	private WebElement Customers;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/suppliers']")
	private WebElement Suppliers;
	
	@FindBy(xpath="//span[text()='Categories ']")
	private WebElement Categories;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/categories']")
	private WebElement Product_Category;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/categorie_expences']")
	private WebElement Expense_Category;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/expences']")
	private WebElement Expenses;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/settings?tab=setting']")
	private WebElement Settings;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/logout']")
	private WebElement Logout;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li")
	private List<WebElement> menu;
	
	@FindBy(xpath="//button[@class='navbar-toggle collapsed']")
	private WebElement menu_icon;
	
	public HomePage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	public WebElement menu_icon()
	{
		
		//wait.explicitWait_elementClickable(getDriver(), menu_icon, Duration.ofSeconds(15));
		//wait.fluentWait(getDriver(), menu_icon, 15);
		return menu_icon;
	}
	
	public List<WebElement> menu()
	{
		return menu;
	}
	public WebElement page_heading()
	{
		return Heading;
	}
	public WebElement products()
	{
		return Products;
	}
	public WebElement stores()
	{
		return Stores;
	}
	public WebElement people()
	{
		return People;
	}
	public WebElement waiters()
	{
		return Waiters;
	}
	public WebElement suppliers()
	{
		return Suppliers;	
	}
	public WebElement Customers()
	{
		return Customers;	
	}
	public WebElement expense_Category()
	{
		return Expense_Category;
	}
	public WebElement product_Category()
	{
		return Product_Category;
	}
	public WebElement categories()
	{
		return Categories;	
	}
	public WebElement expenses()
	{
		return Expenses;
	}
	public WebElement settings()
	{
		return Settings;
	}
	public WebElement language()
	{
		return Language;
	}
	public WebElement language_dropdown()
	{
		return Language_dropdown;
	}
	public WebElement Language_displayed()
	{
		return Language_displayed;
	}
	public WebElement user_name()
	{
		return user_name;
	}
	
	public WebElement logout()
	{
		 return Logout;
	}	
	
	public void logoff()
	{
		wait.explicitWait_elementClickable(getDriver(), Logout,Duration.ofSeconds(5));
		act.click1(hp.logout(), "Logout button click ");
	}

	
	
	
}
