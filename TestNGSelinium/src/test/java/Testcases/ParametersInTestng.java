package Testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParametersInTestng {
	@Parameters({"URL","Username","Password"})
	@Test
	public void program(String SiteUrl,String Uname,String Pwd)
	{
		System.out.println(SiteUrl);
		System.out.println(Uname);
		System.out.println(Pwd);
	}

}
