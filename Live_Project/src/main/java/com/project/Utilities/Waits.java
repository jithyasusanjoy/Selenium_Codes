package com.project.Utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BaseClass.BaseClass;

public class Waits extends BaseClass {
	
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void explicitWait_elementVisibility(WebDriver driver, WebElement element, Duration timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWait_elementClickable(WebDriver driver, WebElement element, Duration timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void explicitWait_elementSelected(WebDriver driver, WebElement element, Duration timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void explicitWait_alertPresent(WebDriver driver, Duration timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void explicitWait_textPresentElement(WebDriver driver, WebElement element,String str, Duration timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.textToBePresentInElement(element, str));
	}
}
