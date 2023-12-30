package Framework.pageobjects;

import java.time.Duration ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Framework.testcomponents.BaseClass;

public class FrameworkClass {
	@Test
	public void mainClass() throws InterruptedException{
		// Launch
		String productname = "IPHONE 13 PRO";
		BaseClass base= new BaseClass(driver);
		base.initDriver();
		LoginPage lp= new LoginPage(driver);
		lp.LoginAction("dnameparas@gmail.com","Paras@123");
		
		ProductCatalog cata=new ProductCatalog(driver);
		cata.selectProduct(productname);
		cata.goToCart();
		
		CartSection carts= new CartSection(driver);
		Boolean match=carts.validItems(productname);
		Assert.assertTrue(match);
		carts.goTopayment();
		
		Checkout checkouts=new Checkout(driver);
		checkouts.country("Ind");
		checkouts.FinalSubmit();
		
		Confirmation con = new Confirmation(driver);
		String sucess=con.textValidate();
		Assert.assertEquals(sucess, "THANKYOU FOR THE ORDER.");
		driver.close();

	}

}
