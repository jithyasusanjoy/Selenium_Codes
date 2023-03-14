
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
import org.openqa.selenium.remote.RemoteWebDriver;
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

	//public static WebDriver driver;
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
	
	//Thread local driver
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite(groups = { "Regression" })
	public void loadingfiles() {
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();
	}

	@BeforeMethod(groups = { "Regression" })
	public void launch() {
		launchApp();
		hp = new HomePage();
		lp = new LoginPage();
		ae = new AddExpense();
		data = new ExcelRead();
		ac1 = new AddCategory();
		as = new AddSupplier();
		aw = new AddWaiter();
		ac = new AddCustomer();
		au = new AddUser();
		awh = new AddWarehouse();
		sp= new StoresPage();
		sm=new StoreManage();
		asp = new AddStorePage();
		pp= new ProductPage(); 
		ap= new AddProductPage();
		pmp = new PrintMenuPage();
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
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	

	public void launchApp() {
		String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());

		}

		getDriver().manage().window().maximize();
		act = new ActionClass();
		act.implicitWait(getDriver(), 10);
		act.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));

	}
	
	
	@AfterMethod(groups = { "Regression" })
	public void user_logout() {
		
		getDriver().quit();
	}


	@AfterSuite(groups = { "Regression" })
	public void Teardown() {

		ExtentReport.endReport();
	}

}
