package Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartSection {

	WebDriver driver;

	public CartSection(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css = ".totalRow button")
	WebElement total;

	public List<WebElement> getCartItems() {

		return cartItems;

	}

	
	public Boolean validItems(String productname) {
		
		Boolean match = cartItems.stream().anyMatch(s -> s.getText().equals(productname));
		return match;
		
	}
	
	public void goTopayment() {
		total.click();
		
	}
	
}

