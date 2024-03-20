package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class MyacctPage {
	WebDriver driver;
	public MyacctPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()=\"Edit your account information\"]")
	WebElement EditacctInfoField;
	
	public WebElement getEditaccInfoField() {
		return EditacctInfoField;
	}
}
