package pack1;

import org.testng.annotations.Test;

public class LifeInsuranceTest {
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
