package maven.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPage extends Abstractmethods  {

	public FinalPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css=".hero-primary")
	WebElement text;
	
	public String verifyConfirmationMessage() {	
	return text.getText();
	
	}

}
