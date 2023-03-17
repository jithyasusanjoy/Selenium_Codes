package com.PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddProductPage extends BaseClass{

	
	@FindBy(xpath="//select[@id='Type']")
	WebElement Type;
	
	@FindBy(xpath="//input[@id='ProductCode']")
	WebElement Code;
	
	@FindBy(xpath="//input[@id='ProductName']")
	WebElement Name;
	
	@FindBy(xpath="//select[@id='Category']")
	WebElement Category;
	
	@FindBy(xpath="//select[@id='Supplier']")
	WebElement Supplier;
	
	@FindBy(xpath="//input[@id='PurchasePrice']")
	WebElement Purchase_Price;
		
	@FindBy(xpath="//input[@id='Tax']")
	WebElement Tax;
	
	@FindBy(xpath="//select[@id='taxType']")
	WebElement Tax_method;
	
	@FindBy(xpath="//input[@id='Price']")
	WebElement Price;
	
	@FindBy(xpath="//input[@id='Unit']")
	WebElement Product_Unit;
	
	@FindBy(xpath="//input[@id='AlertQt']")
	WebElement Alert_Quantity;
	
	@FindBy(xpath="//textarea[@id='ProductOptions']")
	WebElement Product_Options;
	
	@FindBy(xpath="(//input[@id='ImageInput'])[1]")
	WebElement File_Upload;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	WebElement Product_Description;
	
	@FindBy(xpath="//label[@class='btn color04']")
	WebElement Color_Selection;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement Submit_btn;
	
	@FindBy(xpath="(//button[text()='Close'])[2] ")
	WebElement Close_btn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement Search;
	
	@FindBy(xpath="//td[@class='hidden-xs productcode sorting_1']")
	WebElement First_Element;
	
	@FindBy(xpath="(//button[@onclick=\"location.reload();\"])[2]")
	WebElement Stock_close;
	
	
	public AddProductPage() {

		PageFactory.initElements(getDriver(), this);
	}
	
	public WebElement Stock_close()
	{
		return Stock_close;
	}
	public WebElement First_Element()
	{
		return First_Element;
	}

	public WebElement Search()
	{
		return Search;
	}

	public WebElement Tax()
	{
		return Tax;
	}
	public WebElement Tax_method()
	{
		return Tax_method;
	}
	public WebElement Price()
	{
		return Price;
	}
	public WebElement type()
	{
		return Type;
	}
	public WebElement code()
	{
		return Code;
	}
	public WebElement name()
	{
		return Name;
	}
	public WebElement category()
	{
		return Category;
	}
	
	public WebElement supplier()
	{
		return Supplier;
	}
	public WebElement Purchase_price()
	{
		return Purchase_Price;
	}
	public WebElement product_unit()
	{
		return Product_Unit;
	}
	public WebElement alert_quantity()
	{
		return Alert_Quantity;
	}
	public WebElement color_selection()
	{
		return Color_Selection;
	}
	public WebElement product_description()
	{
		return Product_Description;
	}
	public WebElement file_upload()
	{
		return File_Upload;
	}
	public WebElement product_options()
	{
		return Product_Options;
	}
	
	public WebElement Submit_btn()
	{
		return Submit_btn;
	}
	public WebElement Close_btn()
	{
		return Close_btn;
	}
	public void fluentwait(WebElement element, int i)
	{
		act.fluentWait(getDriver(), element,i);
	}
	
}
