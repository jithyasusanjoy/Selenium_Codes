package pack1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeInsuranceTest {
	
	
	@BeforeTest
	public void OpenBrowser()
	{
		System.out.println("Browser Opened");
	}
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("BeforeMethod");
	}
	@Test(priority=3)
	public void HomeInsuranceWebLogin()
	{
		System.out.println("HomeInsuranceWebLogin");
	}
	@Test(priority=2)
	public void HomeInsuranceWebLogout()
	{
		System.out.println("HomeInsuranceWebLogout");
	}
	@Test(priority=-2)
	public void MobileInsuranceWebLogin()
	{
		System.out.println("MobileInsuranceWebLogin");
	}
	@Test(priority=1)
	public void MobileInsuranceWebLogout()
	{
		System.out.println("MobileInsuranceWebLogout");
	}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		System.out.println("Browser Closed");
	}

}
