package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyacctPage;
import resource.Base;
import resource.ExcelReder;

public class LoginTest extends Base {
	public WebDriver driver;
	@BeforeMethod
	public void Openapp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		
	}
	@Test(dataProvider = "getloginData")
	public void Login(String email, String pwd, String expected) throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		lp.getmyaccdropDown().click();
		lp.getloginOption().click();

		LoginPage log = new LoginPage(driver);
		log.getEmailField().sendKeys(email);
		log.getPasswordField().sendKeys(pwd);
		log.getLoginBtn().click();

		MyacctPage map = new MyacctPage(driver);
		String actual = null;
		try {
			if (map.getEditaccInfoField().isDisplayed()) {

				actual = "success";
			}
		} catch (Exception e) {
			actual = "failure";
		}
		Assert.assertEquals(actual, expected);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@DataProvider
	public Object[][] getloginData() throws IOException {

		ExcelReder reader = new ExcelReder();
		Object[][] Data =reader.excelRead();
		return Data;
	}

}
