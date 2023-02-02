package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitClose {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.obsqurazone.com/software-testing-courses-kerala/");
		driver.findElement(By.partialLinkText("About")).click();
		driver.findElement(By.linkText("Learning Paths")).click();
		//driver.quit();
		driver.close();
	}

}
