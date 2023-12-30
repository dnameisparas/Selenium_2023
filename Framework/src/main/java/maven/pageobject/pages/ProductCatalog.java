package maven.pageobject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog extends Abstractmethods {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3 b")
	List<WebElement> products;

	By el_A = By.cssSelector(".mb-3");

	public List<WebElement> getProductList() {

		waiting(el_A);
		return products;
	}

	public void addToCart(String name) {

		for (int i = 0; i < products.size(); i++) {
			String prod = products.get(i).getText();
			if (prod.equalsIgnoreCase(name)) {

				driver.findElement(By.xpath("//button[@Class=\"btn w-10 rounded\"]")).click();
			}
		}
		
	}

}
