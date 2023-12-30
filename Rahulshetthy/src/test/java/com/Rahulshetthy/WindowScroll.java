package com.Rahulshetthy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class WindowScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paras\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement>values=driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//td[4]"));
		System.out.println(values.size());
		int sum =0;
		for(int i=0;i<values.size();i++)
		{
			
		 sum= sum+ Integer.parseInt(values.get(i).getText());
	
		}
		String str=driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total=Integer.parseInt(str.split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		System.out.println("Validated");
		
		
	}

}
