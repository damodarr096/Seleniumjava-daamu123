package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement PasswordField;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement LoginBtn;
	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return PasswordField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	
	
}
