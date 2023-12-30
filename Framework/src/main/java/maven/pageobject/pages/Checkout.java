package maven.pageobject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends Abstractmethods {
	
	WebDriver driver;

	public Checkout(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement coun;
	
	@FindBy(xpath="(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")
	WebElement select;
	
	@FindBy(css =".action__submit")
	WebElement submit;
	
	
	public void countryName(String Country) throws InterruptedException {
		
		coun.sendKeys(Country);
		Thread.sleep(3000);
		select.click();
		
	}
	
	public FinalPage sumbitOrder() {
		submit.click();
		FinalPage thanks= new FinalPage(driver);
		return thanks; 
		}
	
	

}
