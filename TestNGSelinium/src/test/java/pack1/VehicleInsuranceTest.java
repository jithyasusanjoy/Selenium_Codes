package pack1;

import org.testng.annotations.Test;

public class VehicleInsuranceTest {
	@Test(priority=3)
	public void VehicleInsuranceWebLogin()
	{
		System.out.println("VehicleInsuranceWebLogin");
	}
	@Test(priority=2)
	public void VehicleInsuranceWebLogout()
	{
		System.out.println("VehicleInsuranceWebLogout");
	}
	@Test(priority=-2)
	public void VehicleMobileInsuranceWebLogin()
	{
		System.out.println("VehicleMobileInsuranceWebLogin");
	}
	@Test(priority=1)
	public void VehicleMobileInsuranceWebLogout()
	{
		System.out.println("VehicleMobileInsuranceWebLogout");
	}
}
