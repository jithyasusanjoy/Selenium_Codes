package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass.BaseClass;

public class PrintMenuPage extends BaseClass{

	

	@FindBy(xpath = "//h1[text()='Menu']")
	WebElement label;

	@FindBy(xpath = "//button[@onclick='PrintTicket()']")
	WebElement Print;

	@FindBy(xpath = "(//button[text()='Close'])[9]")
	WebElement Close_btn;

	public PrintMenuPage() {
	
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement label() {
		return label;
	}

	public WebElement print() {
		return Print;
	}

	public WebElement Close_btn() {
		return Close_btn;
	}

}
