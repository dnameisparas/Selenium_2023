package maven.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Abstractmethods {

	WebDriver driver;
	
	public Login(WebDriver driver) {
	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement pass;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalog signin(String email,String password)
	{
		userEmail.sendKeys(email);
		pass.sendKeys(password);
		submit.click();
		ProductCatalog product = new ProductCatalog(driver);
		
		return product;
	}
	
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/client");

	}
	}


