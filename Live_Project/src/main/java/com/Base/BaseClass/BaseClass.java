
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.ActionClass.ActionClass;
import com.PageObjects.AddCategory;
import com.PageObjects.AddCustomer;
import com.PageObjects.AddExpense;
import com.PageObjects.AddProductPage;
import com.PageObjects.AddStorePage;
import com.PageObjects.AddSupplier;
import com.PageObjects.AddUser;
import com.PageObjects.AddWaiter;
import com.PageObjects.AddWarehouse;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.PrintMenuPage;
import com.PageObjects.ProductPage;
import com.PageObjects.StoreManage;
import com.PageObjects.StoresPage;
import com.project.Utilities.ExcelRead;
import com.project.Utilities.ExtentReport;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static ActionClass act;
	public static ExcelRead data;
	public static HomePage hp;
	public static LoginPage lp;
	public static AddExpense ae;
	public static ProductPage pp;
	public static AddProductPage ap;
	public static AddCategory ac1;
	public static AddSupplier as;
	public static AddWaiter aw;
	public static AddCustomer ac;
	public static StoresPage sp;
	public static StoreManage sm;
	public static AddStorePage asp;
	public static AddUser au ;
	public static AddWarehouse awh;
	public static PrintMenuPage pmp;

	@BeforeSuite(groups = { "Regression" })
	public void loadingfiles() {
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();
	}

	@BeforeMethod(groups = { "Regression" })
	public void launch() {
		launchApp();
		
	}

	@BeforeTest(groups = { "Regression" })
	public void loadConfig() {

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

	public void launchApp() {
		String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		act = new ActionClass();
		act.implicitWait(driver, 10);
		act.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));

	}
	
	
	@AfterMethod(groups = { "Regression" })
	public void user_logout() {
		
		driver.quit();
	}


	@AfterSuite(groups = { "Regression" })
	public void Teardown() {

		ExtentReport.endReport();
	}

}
