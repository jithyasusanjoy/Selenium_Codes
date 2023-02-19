package setup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Operations {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");

		
		 //Single input 
		  driver.findElement(By.partialLinkText("Simple")).click(); 
		  driver.findElement(By.cssSelector("input[id='single-input-field']")).click();
		  driver.findElement(By.cssSelector("input[id='single-input-field']")). sendKeys("Automation using Selenium"); //
		  driver.findElement(By.cssSelector("button[id='button-one']")).click();
		
		  driver.findElement(By.cssSelector("input[id='single-input-field']")).clear();//clear the input 
	
		  
		  //Two input 
		  driver.findElement(By.cssSelector("input[id='single-input-field']")).click();
		  driver.findElement(By.cssSelector("input[id='value-a']")).sendKeys("10");
		  driver.findElement(By.cssSelector("input[id='value-a']")).click(); 
		  driver.findElement(By.cssSelector("input[id='value-b']")).sendKeys("2"); 
		  driver.findElement(By.cssSelector("input[id='value-b']")).click(); 
		  driver.findElement(By.cssSelector("button[id='button-two']")).click(); 
	
		  
		  //Radio button 
		  driver.findElement(By.linkText("Radio Buttons Demo")).click(); 
		  WebElement
		  radio= driver.findElement(By.id("inlineRadio1")); 
		  radio.click();
		  System.out.println(radio.isEnabled()); 
		  System.out.println(radio.isDisplayed()); 
		  System.out.println(radio.isSelected()); 
		  System.out.println(radio.getAttribute("value")); 
		  driver.findElement(By.xpath("(//button)[2]")).click(); 
		  
		  
		  //Radio button Group 
		  driver.findElement(By.cssSelector("input[id='inlineRadio21']")).click(); 
		  driver.findElement(By.cssSelector("input[id='inlineRadio23']")).click(); 
		  driver.findElement(By.cssSelector("button[id='button-two']")).click(); 
	
		  
		  //Check box 
		  driver.findElement(By.partialLinkText("Checkbox")).click(); 
		  driver.findElement(By.id("gridCheck")).click(); 
		  
		  
		  //Multiple Check box 
		  driver.findElement(By.cssSelector("input[id='check-box-one']")).click(); 
		  driver.findElement(By.cssSelector("input[id='check-box-three']")).click(); 
		 
		  driver.findElement(By.cssSelector("input[id='button-two']")).click(); 
	 
		  driver.findElement(By.cssSelector("input[id='button-two']")).click(); 
		  
		  
		  // Select drop down
		  driver.findElement(By.partialLinkText("Select")).click(); 
		  WebElement select = driver.findElement(By.id("single-input-field")); 
		  select.click();
		 
		  
		  //select class for static dropdown 
		  Select s = new Select(select);
		  s.selectByIndex(1);
		 
		  select.click(); 
		  
		  s.selectByValue("Yellow"); 
		 
		  s.selectByVisibleText("Green");
		  
		  select.click(); 
		  
		   
			  
			// Multi select drop down
			  WebElement select1 = driver.findElement(By.id("multi-select-field"));
			  Select s1 = new Select(select1);
			  s1.selectByIndex(1); 
			  s1.selectByValue("Red");
			  s1.selectByVisibleText("Green");		 
			 
			  //deselect
			  s1.deselectByVisibleText("Green");
			  s1.deselectByIndex(1);
			  s1.deselectByValue("Red");
			  s1.deselectAll();
			 
			  driver.findElement(By.cssSelector("button[id='button-all']")).click();
		  
	}

}
