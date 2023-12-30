package maven.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class windowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/primeday?ref_=PD23_FT_ACQ_H1_PC&pf_rd_r=AJEZ2Z2GC07XDJFD9VHQ&pf_rd_p=2da44a63-2c85-4656-b59d-e888718de86a&pd_rd_r=6b8cab7c-1b82-433e-8b96-516ed02a46f3&pd_rd_w=vhjqa&pd_rd_wg=1wssB&tag=googhydrabk1-21&ascsubtag=_k_CjwKCAjwh8mlBhB_EiwAsztdBNiHKVC2cfhmBAvh3V4p625hnatkVkI3cAKXJkJmmEUNLmeP0LJBFRoC5A0QAvD_BwE_k_&gclid=CjwKCAjwh8mlBhB_EiwAsztdBNiHKVC2cfhmBAvh3V4p625hnatkVkI3cAKXJkJmmEUNLmeP0LJBFRoC5A0QAvD_BwE");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions a= new Actions(driver);
		
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		
		WebElement input=driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(input).click().keyDown(Keys.SHIFT).sendKeys("Iphone 13").build().perform();
		

	}

}
