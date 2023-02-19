package setup;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {


	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.obsqurazone.com/software-testing-courses-kerala/");
		
		//webElements
		
		List<WebElement> e= driver.findElements(By.cssSelector("a[class='course-button']"));
		System.out.println("No of elements are:"+e.size());
		for(WebElement i:e)
		{
			System.out.println("Element"+i);
		}
		
		//getsize
		WebElement element = driver.findElement(By.partialLinkText("Learning"));
		System.out.println("Dimensions are:"+element.getSize());
		
		//getlocation
		System.out.println("Location :"+element.getLocation());
		
		//getcssvalue
		System.out.println("Css value :"+element.getCssValue("font-size"));
		
		driver.close();
		
	}

}
