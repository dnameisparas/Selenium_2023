package maven.pageobject.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCart extends Abstractmethods{
	
	WebDriver driver;

	public MyCart(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//div[@class=\"cartSection\"]/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	public List<WebElement> cartProductsname(){
		return cartProducts;
				
	}

	public void checkForProduct(String name)
	{
		cartProducts.stream().filter(item -> item.getText().equalsIgnoreCase(name));
		System.out.println("cart validated sucessfully");
	
	}
	
	public Checkout goToCheckout()
	{
		checkout.click();
		Checkout exit=new Checkout(driver);
		return exit;
	
	}

}
