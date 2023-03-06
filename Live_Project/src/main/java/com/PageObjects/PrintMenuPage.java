package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintMenuPage {
	
WebDriver driver;
	
	
	
	@FindBy(xpath="//button[@onclick='PrintTicket()']")
	WebElement Print;
	
	@FindBy(xpath="(//button[text()='Close'])[9]")
	WebElement Close_btn;
	
	
	public PrintMenuPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement print()
	{
		return Print;
	}
	public WebElement Close_btn()
	{
		return Close_btn;
	}

}
