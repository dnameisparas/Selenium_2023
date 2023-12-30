package maven.selenium;

import java.util.List ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdowns {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver= new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.manage().window().maximize();
	driver.findElement(By.id("autosuggest")).sendKeys("ind");
	Thread.sleep(2000);
	
	List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	
	for (WebElement option : options) {
		if(option.getText().equalsIgnoreCase("India"))
		{
			option.click();
			break;
		}
	}
	
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@Value='DEL']")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("div[id*='destinationStation1'] a[Value='IXL']")).click();
	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	
	driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
	Thread.sleep(1000);
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	for(int i=1;i<5;i++)
	{	
	driver.findElement(By.id("hrefIncAdt")).click();
	}
	driver.findElement(By.id("btnclosepaxoption")).click();
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	WebElement ele=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select select= new Select(ele);
	select.selectByValue("AED");
	
	}

}
