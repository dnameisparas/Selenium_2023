package maven.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,820)");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();
		while (!driver.findElement(By.className("cur-month")).getText().contains("Sept")) {
			Thread.sleep(1000);

			driver.findElement(By.className("flatpickr-next-month")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
		int count = driver.findElements(By.className("flatpickr-day")).size();
		Thread.sleep(2000);
		for (int i = 0; i < count; i++) {

			String dateNeeded = driver.findElements(By.className("flatpickr-day")).get(i).getText();
			if (dateNeeded.equalsIgnoreCase("24")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				System.out.println("Date Selected");
				break;
			}
		}
	}

}
