package setup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
				driver.manage().window().maximize();
				driver.navigate().to("https://www.obsqurazone.com/software-testing-courses-kerala/");
				driver.findElement(By.linkText("Learning Paths")).click();
				Thread.sleep(4000);
				driver.navigate().back();
				Thread.sleep(4000);
				driver.navigate().forward();
				Thread.sleep(4000);
				driver.navigate().refresh();
				Thread.sleep(2000);
				driver.quit();
	}

}


