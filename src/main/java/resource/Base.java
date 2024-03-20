package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver () throws IOException
	{
		
	    prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.Properties");
		prop.load(fis);
		String browser =prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		 driver =new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
	}
	
	public String takeScreenShot(String testName,WebDriver driver) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String destpath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		 File destfile= new File(destpath);
		 FileUtils.copyFile(srcFile, destfile);
		 return destpath;
	}
}
