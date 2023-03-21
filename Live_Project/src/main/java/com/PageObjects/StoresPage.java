package com.PageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.BaseClass.BaseClass;

public class StoresPage extends BaseClass{

	
	@FindBy(xpath="//select[@name='Table_length']")
	private WebElement Show_Drop;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement Search;
	
	@FindBy(xpath="(//a[@data-original-title='Delete'])[1]")
	private WebElement Delete_Row;
	
	@FindBy(xpath="(//a[@data-original-title='Edit'])[1]")
	private WebElement Edit_Row;
	
	@FindBy(xpath="(//a[@data-original-title='manage Tables'])[1]")
	private WebElement Manage_Table;
	
	@FindBy(xpath="//th[@aria-sort='ascending']")
	private WebElement Sort_Ascending;
	
	@FindBy(xpath="//th[@aria-sort='descending']")
	private WebElement Sort_Descending;
	
	@FindBy(xpath="//button[@data-target='#AddStore']")
	private WebElement Add_Store;
	
	@FindBy(xpath="//a[@data-dt-idx='3']")
	private WebElement Pagination;
	
	@FindBy(xpath="(//td[@class='sorting_1'])[1]")
	private WebElement First_Element;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	private WebElement No_Element;
	
	@FindBy(xpath="//table[@id='Table']//thead/tr/th")
	private List<WebElement> table_headings;
	
	@FindBy(xpath="//table[@id='Table']//tbody/tr/td[1]")
	private List<WebElement> table_rows;
	
	@FindBy(xpath="//div[contains(text(),'Showing 21 to 30')]")
	private WebElement validate_Page;
	
	 

	public StoresPage() {
	
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public WebElement validate_Page()
	{
		return validate_Page;
	}
	public List<WebElement> table_rows()
	{
		return table_rows;
	}
	public List<WebElement> table_headings()
	{
		return table_headings;
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
		wait.fluentWait(getDriver(), Search, 5);
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
	public WebElement sort_descending()
	{
		return Sort_Ascending;
	}
	
	public WebElement sort_ascending()
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
	public WebElement Manage_Table()
	{
		return Manage_Table;
	}
	
}
