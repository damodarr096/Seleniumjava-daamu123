package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resource.Base;

public class TestTwo extends Base {
public WebDriver driver;
	@Test
	public void testTwo () throws IOException, InterruptedException
	{
		driver = initializeDriver();	
		driver.get("https://www.selenium.dev/");		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}
}
