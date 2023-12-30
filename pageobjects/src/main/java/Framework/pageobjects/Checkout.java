package Framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends AbstractMethods {
	WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By Findby=By.cssSelector(".ta-results");
	
	public void country(String countryName) {
		
		
		country.sendKeys(countryName);
		visibilityOfElementLocated(Findby);
		selectCountry.click();
		
	}
	
	public void FinalSubmit() {
		
		submit.click();
		
	}
	
	
	
	
}



