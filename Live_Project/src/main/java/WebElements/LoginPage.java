package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver driver;

	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement login;
	
	@FindBy(xpath="//h1[text()='Login']")
	WebElement login_label;
	
	
	public LoginPage(WebDriver driver) {
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
	public WebElement login_label()
	{
		return login_label;
	}
	public void LoginFn()
	{
		act.type(username,prop.getProperty("Username"));
		act.type(password,prop.getProperty("Password"));
		act.click1(login,"Clicking On Login Button");
	}
	
}
