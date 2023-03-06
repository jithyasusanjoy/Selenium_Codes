package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilePopup {
WebDriver driver;
	
	@FindBy(xpath="(//input[@id='ImageInput'])[2]")
	WebElement File;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	WebElement Submit_btn;
	
	@FindBy(xpath="(//button[@class='btn btn-default'])[4]")
	WebElement Close_btn;
	
	
	public UploadFilePopup(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement file()
	{
		return File;
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
