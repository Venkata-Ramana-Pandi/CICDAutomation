package VenkataRamanapandi.Tests;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import VenkataRamanapandi.AbstractComponents.AbstractComponents;
import VenkataRamanapandi.TestComponents.BaseTest;
import VenkataRamanapandi.pageobjects.Address;
import VenkataRamanapandi.pageobjects.CartPage;
import VenkataRamanapandi.pageobjects.Confirmationpage;
import VenkataRamanapandi.pageobjects.LandingPage;
import VenkataRamanapandi.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {
 
	@Test(dataProvider = "getData", dataProviderClass = BaseTest.class)
	public void SubmitMethod(HashMap<String, String> input) throws IOException
	{
		
		//String Productname="ZARA COAT 3";
		
		//landingpage
		ProductCatalogue productcatalogue=landingpage.landingpage(input.get("email"),input.get("password"));
		
		//productcatalogue
		List<WebElement> products=productcatalogue.Products();
		WebElement getProduct=productcatalogue.getProductByName(input.get("productname"));
		productcatalogue.addProductToCart(input.get("productname"));
		CartPage cartpage=productcatalogue.AddCart();
		
		//cartPage
		List<WebElement> cartproducts=cartpage.cartProducts();
		Boolean match=cartpage.matchedProducts(input.get("productname"));
		Assert.assertTrue(match);
		Address adr=cartpage.ClickCheckout();
		
		//AddressPage
		Confirmationpage confirmationpage=adr.Actions();
		
		//ConfirmationPage
		String msg=confirmationpage.comparison();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		
		
	}
	

}
