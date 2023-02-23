package pack1;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class VehicleInsuranceTest {
	
	/*
	 * @BeforeGroups("United India Assurance") public void before_it() {
	 * System.out.println("--------Before group----------"); }
	 * 
	 * 
	 * @Test public void three_wheeler() { System.out.println("Auto Insurance"); }
	 * 
	 * 
	 * 
	 * @Test(groups= {"United India Assurance"}) public void four_wheeler() {
	 * System.out.println("Car Insurance"); }
	 * 
	 * @Test(groups= {"United India Assurance"}) public void two_wheeler() {
	 * System.out.println("Bike Insurance"); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @AfterGroups("United India Assurance") public void after_it() {
	 * System.out.println("--------After group----------"); }
	 */
	
	@BeforeGroups("United India Assurance")  
	public void before_it()  
	{  
	System.out.println("--------Before group----------");  
	}  
	@AfterGroups("United India Assurance") 
	public void after_it() 
	{
	System.out.println("--------After group----------");
	}
	
	@Test  
	public void three_wheeler()  
	{  
	System.out.println("Auto Insurance");  
	}  
	 @Test(groups= {"United India Assurance"})  
	public void four_wheeler() 
	{  
	System.out.println("Car Insurance");  
	}  
	@Test(groups= {"United India Assurance"})  
	public void two_wheeler()  
	{  
	System.out.println("Bike Insurance");  
	}  
	
}
