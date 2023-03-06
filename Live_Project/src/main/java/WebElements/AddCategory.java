package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategory {
WebDriver driver;
	
	@FindBy(xpath="//button[@data-target='#Addcategory'] ")
	WebElement Add_Category;
	
	@FindBy(xpath="//input[@id='CategoryName']")
	WebElement Category_Name;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement Submit_btn1;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement Close_btn1;
	
	
	
	
	
	public AddCategory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement add_Category()
	{
		return Add_Category;
	}
	public WebElement category_Name()
	{
		return Category_Name;
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
