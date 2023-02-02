package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InitialSetup {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); //WebDriver is an interface and driver is an instance
		driver.manage().window().maximize(); //Maximize current window
		driver.get("https://mvnrepository.com/"); //load the web page
		System.out.println("Title:"+ driver.getTitle()); //Retrieve the title of the web page 
		System.out.println("Current Url:"+ driver.getCurrentUrl()); //Retrieve the URL of the web page
		System.out.println("Page Source:"+ driver.getPageSource()); //Retrieve the page source	
		driver.close();
		
		
	}

}
