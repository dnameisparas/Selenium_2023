package Framework.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public WebDriver driver;
	public WebDriver initDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\GlobalData.properties");
		prop.load(file);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
				driver = new ChromeDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		return driver;
	}

}
