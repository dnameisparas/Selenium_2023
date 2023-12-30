package Framework.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {
	WebDriver driver;
		
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	
	public AbstractMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}

	public void visibilityOfElement(WebElement toast) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(toast));
	}
	
	public void visibilityOfElementLocated(By Findby) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Findby));
	}
	
	public void goToCart() {
		
		cart.click();
	}
	
	
	
}
