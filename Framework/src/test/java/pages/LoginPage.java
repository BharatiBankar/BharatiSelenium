package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
	
		this.driver=ldriver;	
	}
	
	@FindBy(name="email")WebElement uname;
	
	@FindBy(name="password")WebElement pass;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")WebElement loginButton;
	
	public void loginToCRM(String usernameApp, String passwordApp)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		uname.sendKeys(usernameApp);
		pass.sendKeys(passwordApp);
		
		loginButton.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
