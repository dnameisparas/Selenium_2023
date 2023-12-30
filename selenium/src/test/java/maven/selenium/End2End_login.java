package maven.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class End2End_login {

	public static void main(String[] args) throws InterruptedException {
		// Launch
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		String productname = "IPHONE 13 PRO";
		// Login
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.id("userEmail")).sendKeys("dnameparas@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Paras@123");
		driver.findElement(By.id("login")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement ourProduct = products.stream()
				.filter(name -> name.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst()
				.orElse(null);

		ourProduct.findElement(By.cssSelector(".mb-3 button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".toast-container"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartItems.stream().anyMatch(s -> s.getText().equals(productname));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("Ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String sucess=driver.findElement(By.className("hero-primary")).getText();
		Assert.assertEquals(sucess, "THANKYOU FOR THE ORDER.");
		driver.close();

	}

}
