package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigDataProvider 
{
	Properties pro;
	public ConfigDataProvider()
	{
			File src=new File("./Config/config.properties");
	
			try {
				FileInputStream fis=new FileInputStream(src);
				pro=new Properties();
				pro.load(fis);
			} catch (Exception e) {
				System.out.println("Not able to load cnfig file"+e.getMessage());
			} 
	}
	
	public String getDatafromCofig(String KeyToSearch)
	{
		return pro.getProperty(KeyToSearch);
	}
	 public String getBrowser()
	 {
		 return pro.getProperty("Browser");
		 
	 }

	 public String getStagingURL()
	 {
		 return pro.getProperty("qaUrl");
	 }
	
}
