package maven.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class limitingDriver {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> links=column.findElements(By.tagName("a"));
		
		Actions a= new Actions(driver);
		for(int i=1; i<links.size(); i++) {
			
			a.keyDown(Keys.CONTROL).build().perform();
			links.get(i).click();
			Thread.sleep(2000);

		}
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		while(it.hasNext())
		{
		 System.out.println(driver.switchTo().window(it.next()).getTitle());
		 
			
		}

	}

}
