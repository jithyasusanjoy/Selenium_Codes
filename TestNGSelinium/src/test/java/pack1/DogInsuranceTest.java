package pack1;

import org.testng.annotations.Test;

public class DogInsuranceTest {
	
	@Test(priority=3)
	public void DogInsuranceWebLogin()
	{
		System.out.println("DogInsuranceWebLogin");
	}
	@Test(priority=2)
	public void DogInsuranceWebLogout()
	{
		System.out.println("DogInsuranceWebLogout");
	}
	@Test(priority=-2)
	public void DogMobileInsuranceWebLogin()
	{
		System.out.println("DogMobileInsuranceWebLogin");
	}
	@Test(priority=1)
	public void DogMobileInsuranceWebLogout()
	{
		System.out.println("DogMobileInsuranceWebLogout");
	}
}
