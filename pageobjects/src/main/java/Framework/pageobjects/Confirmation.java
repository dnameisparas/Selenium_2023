package Framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation extends AbstractMethods {

	
	WebDriver driver;

	public Confirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="hero-primary")
	WebElement text;
	
	public String textValidate() {
		
		String sucess= text.getText();
		 return sucess;
	}
}
