package maven.selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractise1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		String[] itemsNeeded= {"Cucumber","Beetroot","Tomato","Apple"};
		int j=1;

		List<WebElement> veggies = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < veggies.size(); i++) {
			String[] name = veggies.get(i).getText().split("-");
			String formattedName= name[0].trim();
			
			List items=Arrays.asList(itemsNeeded);

			if (items.contains(formattedName)) {
				
				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length)
				{
					
					break;
				}
				
				
			}

		}

	}

}
