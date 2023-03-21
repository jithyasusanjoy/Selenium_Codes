package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class AddProductPage extends BaseClass{

	
	@FindBy(xpath="//select[@id='Type']")
	private WebElement Type;
	
	@FindBy(xpath="//input[@id='ProductCode']")
	private WebElement Code;
	
	@FindBy(xpath="//input[@id='ProductName']")
	private WebElement Name;
	
	@FindBy(xpath="//select[@id='Category']")
	private WebElement Category;
	
	@FindBy(xpath="//select[@id='Supplier']")
	private WebElement Supplier;
	
	@FindBy(xpath="//input[@id='PurchasePrice']")
	private WebElement Purchase_Price;
		
	@FindBy(xpath="//input[@id='Tax']")
	private WebElement Tax;
	
	@FindBy(xpath="//select[@id='taxType']")
	private WebElement Tax_method;
	
	@FindBy(xpath="//input[@id='Price']")
	private WebElement Price;
	
	@FindBy(xpath="//input[@id='Unit']")
	private WebElement Product_Unit;
	
	@FindBy(xpath="//input[@id='AlertQt']")
	private WebElement Alert_Quantity;
	
	@FindBy(xpath="//textarea[@id='ProductOptions']")
	private WebElement Product_Options;
	
	@FindBy(xpath="(//input[@id='ImageInput'])[1]")
	private WebElement File_Upload;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement Product_Description;
	
	@FindBy(xpath="//label[@class='btn color04']")
	private WebElement Color_Selection;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement Submit_btn;
	
	@FindBy(xpath="(//button[text()='Close'])[2] ")
	private WebElement Close_btn;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement Search;
	
	@FindBy(xpath="//td[@class='hidden-xs productcode sorting_1']")
	private WebElement First_Element;
	
	@FindBy(xpath="(//button[@onclick=\"location.reload();\"])[2]")
	private WebElement Stock_close;
	
	
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
		wait.fluentWait(getDriver(), Search, 5);
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
		wait.fluentWait(getDriver(), File_Upload, 5);
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
	
	
}
