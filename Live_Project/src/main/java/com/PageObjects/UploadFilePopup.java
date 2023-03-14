package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class UploadFilePopup extends BaseClass{

	
	@FindBy(xpath="(//input[@id='ImageInput'])[2]")
	WebElement File;
	
	@FindBy(xpath="(//button[@type='submit'])[3]")
	WebElement Submit_btn;
	
	@FindBy(xpath="(//button[@class='btn btn-default'])[4]")
	WebElement Close_btn;
	
	
	public UploadFilePopup(WebDriver driver) {
				PageFactory.initElements(getDriver(), this);
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
