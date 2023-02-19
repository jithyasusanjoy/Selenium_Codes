 package setup;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booking.com/");
		driver.findElement(By.linkText("Flights")).click();
		
		// select trip
		
		driver.findElement(By.xpath("(//span[@class='InputRadio-module__field___hylYy'])[2]")).click();
	
		
		//select passengers
		
		
		driver.findElement(By.cssSelector("div[data-testid='input_occupancy_desktop_passengers_trigger']")).click();
		
		driver.findElement(By.cssSelector("button[data-testid='input_occupancy_modal_adults_increase']")).click();
		
		driver.findElement(By.cssSelector("button[data-testid='input_occupancy_modal_children_increase']")).click();
		
		WebElement select = driver.findElement(By.cssSelector("select[class='InputSelect-module__field___E9sYJ']"));
		Select s1 = new Select(select);
		s1.selectByValue("3");
		driver.findElement(By.cssSelector("div[data-testid='input_occupancy_desktop_passengers_trigger']")).click();
		
		
		
		//select destination
		
	    driver.findElement(By.cssSelector("input[placeholder='Where to?']")).click(); 	
	   
	    driver.findElement(By.cssSelector("input[class='css-11ryvth']")).sendKeys("TRV");
	   
	    List<WebElement> l=driver.findElements(By.cssSelector("li[class='css-7grkf7']")); 
		   for(WebElement i:l)
		    { 	    
		     i.click(); 		     
		     } 	
		  
		   
			/*
			 * // select date
			 * 
			 * driver.findElement(By.cssSelector("input[placeholder='Depart']")).click();
			 *
			 * driver.findElement(By.xpath("//span[@data-date-cell='2023-03-13']")).click();
			 *
			 */
		   
		//searching for flights   
		   
		driver.findElement(By.cssSelector(" button[data-testid='searchbox_submit']")).click(); 
		
		
		//searching cheapest flights
		
		driver.findElement(By.xpath("//button[@aria-controls='CHEAPEST']")).click();
		
		WebElement result=driver.findElement(By.xpath("//div[@id='flightcard-0']")); 
		System.out.println(result.getText());
		
		  
	}
}
