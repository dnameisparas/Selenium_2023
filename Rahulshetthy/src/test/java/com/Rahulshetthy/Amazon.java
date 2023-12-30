package com.Rahulshetthy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paras\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		
		//MouseHover
		Actions act= new Actions(driver);
		WebElement hover = driver.findElement(By.cssSelector(".nav-line-1-container"));
		act.moveToElement(hover).build().perform();
		
		//KeyBoard
		WebElement text = driver.findElement(By.id("twotabsearchtextbox"));
		act.moveToElement(text).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
	}

}
