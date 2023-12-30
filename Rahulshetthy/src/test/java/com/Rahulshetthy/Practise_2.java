package com.Rahulshetthy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practise_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paras\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//GetAllLinks Count	
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		
		//GetAllLinks Count	in footer
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//clickAll links in first column
		WebElement child=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul[1]"));
		List<WebElement> childSize= child.findElements(By.tagName("a"));
		System.out.println(child.findElements(By.tagName("a")).size());
		
		
		//Get all titles
		for(int i=1;i<childSize.size();i++)
		{
			Actions act= new Actions(driver);
			act.keyDown(Keys.CONTROL).build().perform();
			Thread.sleep(2000);
			child.findElements(By.tagName("a")).get(i).click();
		}
		
		Set<String> handles = driver.getWindowHandles();	
		Iterator<String> it= handles.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		

	}

}
