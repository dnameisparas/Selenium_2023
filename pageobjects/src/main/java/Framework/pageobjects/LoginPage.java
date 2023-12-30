package Framework.pageobjects;

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
	
	@FindBy(id="userEmail")
	WebElement email;

	@FindBy(id="userPassword")
	WebElement password;

	@FindBy(id="login")
	WebElement submit;
	

	public void LoginAction(String emailid, String pass)
	{
		email.sendKeys(emailid);
		password.sendKeys(pass);
		submit.click();
	}

}
