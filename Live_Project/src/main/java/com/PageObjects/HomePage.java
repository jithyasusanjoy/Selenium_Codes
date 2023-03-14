package com.PageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.BaseClass.BaseClass;

public class HomePage extends BaseClass{
	
	
	@FindBy(xpath="//h1[@class='text-center choose_store']")
	WebElement Heading;
	
	@FindBy(xpath="//span[@class='hidden-xs']")
	WebElement user_name;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']//img[@src='https://qalegend.com/restaurant/assets/img/flags/en.png']")
	WebElement Language_dropdown;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/dashboard/change/english']")
	WebElement Language;
		
	@FindBy(xpath="//img[@src='https://qalegend.com/restaurant/assets/img/flags/en.png']")
	WebElement Language_displayed;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/products']")
	WebElement Products;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/stores']")
	WebElement Stores;
	
	@FindBy(xpath="//span[text()='People']")
	WebElement People ;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/waiters']")
	WebElement Waiters;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/customers']")
	WebElement Customers;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/suppliers']")
	WebElement Suppliers;
	
	@FindBy(xpath="//span[text()='Categories ']")
	WebElement Categories;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/categories']")
	WebElement Product_Category;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/categorie_expences']")
	WebElement Expense_Category;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/expences']")
	WebElement Expenses;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/settings?tab=setting']")
	WebElement Settings;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/restaurant/logout']")
	WebElement Logout;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li")
	List<WebElement> menu;
	
	
	public HomePage() {
		
		PageFactory.initElements(getDriver(), this);
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
		act.click1(hp.logout(), "Logout done");
	}
		
	
	
}
