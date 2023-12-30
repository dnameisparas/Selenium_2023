package maven.pageobject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import maven.pageobject.pages.Login;

public class BaseClass {
	public String name = "ZARA COAT 3";
	public WebDriver driver;
	public Login log; 

	public WebDriver InitializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//maven//pageobject//resources//GlobalData.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {

			// FireFox
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod
	public Login launchApplication() throws IOException {

		driver = InitializeDriver();
		log = new Login(driver);
		log.goTo();
		return log;
	}

	@AfterMethod

	public void closeBrowser() {
		driver.close();
	}

}
