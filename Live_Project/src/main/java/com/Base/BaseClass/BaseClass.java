
package com.Base.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ActionClass.ActionClass;
import com.project.Utilities.ExtentReport;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static ActionClass act;
	
	
	@BeforeSuite
	public void loadConfig() {
		
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();
		  
		try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public void launchApp()
	{
		String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			 driver =new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
		     driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
		      driver = new EdgeDriver();
		      
		}
	
		driver.manage().window().maximize();
		 act = new ActionClass();
		
		act.implicitWait(driver, 10);
	
		act.pageLoadTimeOut(driver, 30);   
		driver.get(prop.getProperty("url"));
		 	
	}
	@AfterSuite()
	public void Teardown()
	{
		driver.close();
	}
	
}
