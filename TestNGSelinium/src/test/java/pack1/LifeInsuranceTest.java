package pack1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LifeInsuranceTest {
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("-------ExecuteBeforeSuite---------------");
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("-------ExecuteAfterSuite---------------");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("-------BeforeMethod---------------");
	}
	
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("-------AfterMethod---------------");
	}
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("-------ExecuteBeforeClass---------------");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("-------ExecuteAfterClass---------------");
	}
	
	
	@Test(priority=3)
	public void LifeInsuranceWebLogin()
	{
		System.out.println("LifeInsuranceWebLogin");
	}
	@Test(priority=2)
	public void LifeInsuranceWebLogout()
	{
		System.out.println("LifeInsuranceWebLogout");
	}
	@Test(priority=-2)
	public void LifeMobileInsuranceWebLogin()
	{
		System.out.println("LifeMobileInsuranceWebLogin");
	}
	@Test(priority=1)
	public void LifeMobileInsuranceWebLogout()
	{
		System.out.println("LifeMobileInsuranceWebLogout");
	}
}
