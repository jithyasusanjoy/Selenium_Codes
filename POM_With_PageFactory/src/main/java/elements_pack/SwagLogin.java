package elements_pack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SwagLogin {
	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement login;
	
	

	public SwagLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement uname()
	{
		return username;
	}
	public WebElement pwd()
	{
		return password;
	}
	public WebElement lbutton()
	{
		return login;
	}
	
	
	
	
}
