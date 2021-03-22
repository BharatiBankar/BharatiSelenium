package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("setting up reports and Test is getting ready", true);
			
		excel=new ExcelDataProvider();
		config= new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Report/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
		 report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("setting done-Test can be started", true);
	}
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String url)
	{
		Reporter.log("Browsser and Application is up & runnig", true);
		//driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());
		driver=BrowserFactory.startApplication(driver,browser,url);
	}
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitebrowser(driver);
	}
	
	@AfterMethod
	public void TearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test s about to end", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		report.flush();
		Reporter.log("Test completed >> Reports generated", true);
	}

}
