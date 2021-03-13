package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;


public class LoginTest extends BaseClass 
{
	@Test(priority=1)
	public void loginApp()
	{
		
		logger=report.createTest("Login to CRM");
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		loginpage.loginToCRM(excel.getStringData("LoginPage", 0, 0),excel.getStringData("LoginPage", 0, 1));
		logger.pass("login success");
	}
	
}
