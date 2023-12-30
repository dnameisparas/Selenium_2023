package com.Rahulshetthy;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paras\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		String[] names= {"Brocolli","Cucumber","Beetroot"};
		Practise_1 p=new Practise_1();
		p.adding(driver, names);
	    
	}
	
	public void adding(WebDriver driver,String[] names) {
		
List<WebElement> veggies=driver.findElements(By.cssSelector("h4.product-name"));
		
		veggies.toArray();	
		for(int i=0;i<veggies.size();i++)
		{
			
			String[] veggiesName= veggies.get(i).getText().split("-");
			String formmattedName=veggiesName[0].trim();
			 
			List itemList=Arrays.asList(names);
			
			if(itemList.contains(formmattedName))
					{
		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
		
		}	
			
			
	}
		System.out.println("All Veggies has been added");
	}
	}

