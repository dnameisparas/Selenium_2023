package maven.Framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {

		
		//Initializing webDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

		String name = "IPHONE 13 PRO";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login
		driver.findElement(By.id("userEmail")).sendKeys("paras@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Paytm123");
		driver.findElement(By.id("login")).click();

		System.out.println("Logged in");
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		//Adding products to cart
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3 b"));
		
		for (int i = 0; i < products.size(); i++) {
			String prod = products.get(i).getText();
			if (prod.equalsIgnoreCase(name)) {
				
				driver.findElement(By.xpath("//button[@Class=\"btn w-10 rounded\"]")).click();
			}
		}
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();
		
		//Cart Validation
		List<WebElement> cart=driver.findElements(By.xpath("//div[@class=\"cartSection\"]/h3"));
		cart.stream().filter(item-> item.getText().equalsIgnoreCase(name));
		System.out.println("cart validated sucessfully");
		
		//Checkout
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ta-results list-group ng-star-inserted")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String elements=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(elements);
 
	}

}
