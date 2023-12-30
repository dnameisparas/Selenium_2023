package Framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog extends AbstractMethods {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".toast-container")
	WebElement toast;

	By select = By.cssSelector(".mb-3 button:last-of-type");

	public List<WebElement> productList() {
		return products;

	}

	public WebElement getProduct(String productname) {

		WebElement ourProduct = productList().stream()
				.filter(name -> name.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst()
				.orElse(null);

		return ourProduct;
	}

	public void selectProduct(String productname)throws InterruptedException {

		WebElement finalProd = getProduct(productname);
		finalProd.findElement(select).click();
		visibilityOfElement(toast);
		Thread.sleep(2000);

	}

}
