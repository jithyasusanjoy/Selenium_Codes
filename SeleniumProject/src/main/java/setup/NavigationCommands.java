package setup;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.navigate().to("https://www.obsqurazone.com/software-testing-courses-kerala/");
				driver.findElement(By.linkText("Learning Paths")).click();
				
				driver.navigate().back();
			
				driver.navigate().forward();
			
				driver.navigate().refresh();
				
				driver.quit();
	}

}


