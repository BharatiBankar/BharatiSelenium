package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{
	public static String captureScreenshot(WebDriver driver)
	{
	
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotpath=System.getProperty("user.dir")+"./Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("Screenshot captured successfully");
		} catch (Exception e)
		{
		
			System.out.println("unable to capture screenshot"+e.getMessage());
		}
		return screenshotpath;
	}
	
	public  static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_SS");
	
		Date currentDateFormat=new Date();
		return customFormat.format(currentDateFormat);
	}

}
