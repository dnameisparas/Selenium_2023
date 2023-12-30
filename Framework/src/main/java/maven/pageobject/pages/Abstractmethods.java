package maven.pageobject.pages;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractmethods {

	WebDriver driver;
	
	public Abstractmethods(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//button[@routerlink=\"/dashboard/cart\"]")
	WebElement cartheader;
	
	
	
	public void waiting(By findby) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	
	public MyCart goToCart() {
	
		cartheader.click();
		MyCart names= new MyCart(driver);
		return names;
	
	}
	}


