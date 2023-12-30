package maven.Framework;

import java.io.IOException;
import org.testng.annotations.Test;

import maven.pageobject.base.BaseClass;
import maven.pageobject.pages.Checkout;
import maven.pageobject.pages.FinalPage;
import maven.pageobject.pages.MyCart;
import maven.pageobject.pages.ProductCatalog;

public class End2EndPOM extends BaseClass{

	
	@Test
	public void submitOrder() throws IOException, InterruptedException {
	
		ProductCatalog product=log.signin("paras@gmail.com", "Paytm123");
		System.out.println("Logged in");
		//List<WebElement> productlist = product.getProductList();
		product.addToCart(name);
		Thread.sleep(3000);  
		MyCart names=log.goToCart();
		names.checkForProduct(name);
		Checkout exit=names.goToCheckout();
		exit.countryName("india");
		FinalPage thanks=exit.sumbitOrder();
		thanks.verifyConfirmationMessage();
		
	}
	

}
