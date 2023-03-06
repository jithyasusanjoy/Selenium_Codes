package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
WebDriver driver;
	
	@FindBy(xpath="//button[@data-target='#Addproduct']")
	WebElement Add_Product;
	
	@FindBy(xpath="//a[@data-target='#ImportProducts']")
	WebElement Upload_CSV;
	
	@FindBy(xpath="//a[@href='products/csv']")
	WebElement Download_CSV;
	
	@FindBy(xpath="//a[@data-target='#PrintMenu']")
	WebElement Print_Menu;
	
	@FindBy(xpath="(//input[@id='ImageInput'])[2]")
	WebElement File_Upload;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	WebElement Submit_btn;
	
	

	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement Submit_btn()
	{
		return Submit_btn;
	}
	public WebElement file_upload()
	{
		return File_Upload;
	}
	public WebElement add_product()
	{
		return Add_Product;
	}
	public WebElement upload_CSV()
	{
		return Upload_CSV;
	}
	public WebElement download_CSV()
	{
		return Download_CSV;
	}
	public WebElement print_Menu()
	{
		return Print_Menu;
	}
}
