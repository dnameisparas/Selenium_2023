package com.Rahulshetthy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paras\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		//Login Page
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("Paras Taneja");
		driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).sendKeys("Parastaneja@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder=\"Phone Number\"]")).sendKeys("777777777");
		driver.findElement(By.className("reset-pwd-btn")).click();
		Locators loc= new Locators();
		String password=loc.getPassword(driver);
		
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Paras");
		driver.findElement(By.xpath("//*[@name=\"inputPassword\"]")).sendKeys(password);
		driver.findElement(By.className("submit")).click();
		System.out.println("Login Successfull");
		
		
		
		
		//CHECKBOXES
		/*System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected());
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).isSelected());
		System.out.println(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size());*/

	}
	public String getPassword(WebDriver driver)
	{
		String passwrd= driver.findElement(By.className("infoMsg")).getText();
		System.out.println(passwrd);
		String[] passwordarr = passwrd.split("'");
		String[] passwordarr2=passwordarr[1].split("'");
		String password= passwordarr2[0];
		System.out.println(password);
		return password;
		
	}

}
