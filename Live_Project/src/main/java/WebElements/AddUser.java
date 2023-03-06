package WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUser {
WebDriver driver;
	
	@FindBy(xpath="//a[@href='#users']")
	WebElement User_tab;
	
	@FindBy(xpath="//button[@data-target='#AddUser']")
	WebElement Add_User;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirm_password;
	
	@FindBy(xpath="//input[@value='admin']")
	WebElement rbtn_admin;
	
	@FindBy(xpath="//input[@value='sales']")
	WebElement rbtn_sales;
	
	@FindBy(xpath="//input[@value='waiter']")
	WebElement rbtn_waiter;
	
	@FindBy(xpath="//input[@value='kitchen']")
	WebElement rbtn_kitchen;
	
	@FindBy(xpath="//input[@id='Avatar']")
	WebElement file;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement Submit_btn2;
	
	@FindBy(xpath="(//button[text()='Close'])[1]")
	WebElement Close_btn1;
	
	

	
	
	
	public AddUser(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement user_tab()
	{
		return User_tab;
	}
	public WebElement add_User()
	{
		return Add_User;
	}
	public WebElement username()
	{
		return Username;
	}
	public WebElement firstname()
	{
		return firstname;
	}
	public WebElement lastname()
	{
		return lastname;
	}
	public WebElement Submit_btn()
	{
		return Submit_btn2;
	}
	public WebElement Close_btn()
	{
		return Close_btn1;
	}
	public WebElement email()
	{
		return email;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement confirm_password()
	{
		return confirm_password;
	}
	public WebElement rbtn_kitchen()
	{
		return rbtn_kitchen;
	}
	public WebElement rbtn_waiter()
	{
		return rbtn_waiter;
	}
	public WebElement rbtn_sales()
	{
		return rbtn_sales;
	}
	public WebElement rbtn_admin()
	{
		return rbtn_admin;
	}
	
	public WebElement file()
	{
		return file;
	}
	
}
