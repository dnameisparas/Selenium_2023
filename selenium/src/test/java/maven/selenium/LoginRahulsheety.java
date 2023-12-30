package maven.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginRahulsheety {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();
		String parent=it.next();
		String chlid=it.next();
		
		driver.switchTo().window(chlid);
		Thread.sleep(3000);
		
		String email=driver.findElement(By.xpath("//a[text()='mentor@rahulshettyacademy.com']")).getText();
		driver.switchTo().window(parent);
		
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys("learning");
		
		
		
		
	}

}
