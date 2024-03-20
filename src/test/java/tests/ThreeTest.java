package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resource.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void testThree () throws IOException, InterruptedException
	{
		driver = initializeDriver();	
		driver.get("https://www.google.com/");		
		System.out.println(driver.getTitle());
		Assert.assertTrue(false);
		Thread.sleep(2000);
//		driver.quit();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
