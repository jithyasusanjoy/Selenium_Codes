package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoresPage {
WebDriver driver;
	
	@FindBy(xpath="//select[@name='Table_length']")
	WebElement Show_Drop;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement Search;
	
	@FindBy(xpath="(//a[@data-original-title='Delete'])[1]")
	WebElement Delete_Row;
	
	@FindBy(xpath="(//a[@data-original-title='Edit'])[1]")
	WebElement Edit_Row;
	
	@FindBy(xpath="(//a[@data-original-title='manage Tables'])[1]")
	WebElement Manage_Table;
	
	@FindBy(xpath="//th[@aria-sort='ascending']")
	WebElement Sort_Ascending;
	
	@FindBy(xpath="//th[@aria-sort='descending']")
	WebElement Sort_Descending;
	
	@FindBy(xpath="//button[@data-target='#AddStore']")
	WebElement Add_Store;
	
	@FindBy(xpath="//a[@data-dt-idx='3']")
	WebElement Pagination;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	WebElement First_Element;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement No_Element;
	

	public StoresPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement No_Element()
	{
		return No_Element;
	}

	public WebElement show_drop()
	{
		return Show_Drop;
	}
	public WebElement First_Element()
	{
		return First_Element;
	}
	public WebElement search()
	{
		return Search;
	}
	public WebElement delete_row()
	{
		return Delete_Row;
	}
	public WebElement Edit_Row()
	{
		return Edit_Row;
	}
	public WebElement sort_ascending()
	{
		return Sort_Ascending;
	}
	
	public WebElement sort_descending()
	{
		return Sort_Descending;
	}
	public WebElement add_store()
	{
		return Add_Store;
	}
	public WebElement pagination()
	{
		return Pagination;
	}
	
}
