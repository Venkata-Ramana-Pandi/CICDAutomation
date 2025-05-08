package VenkataRamanapandi.Tests;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import VenkataRamanapandi.AbstractComponents.AbstractComponents;
import VenkataRamanapandi.pageobjects.Address;
import VenkataRamanapandi.pageobjects.CartPage;
import VenkataRamanapandi.pageobjects.Confirmationpage;
import VenkataRamanapandi.pageobjects.LandingPage;
import VenkataRamanapandi.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standalone {

	public static void main(String[] args) 
	{
		String Productname="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		AbstractComponents abc=new AbstractComponents(driver);
		abc.ImplicitWait();
		
		
		//landingpage
		LandingPage landingpage=new LandingPage(driver);
		landingpage.link();	
		ProductCatalogue productcatalogue=landingpage.landingpage("pvramana1819@gmail.com","Venkat@1");
		
		
		//productcatalogue
		
		List<WebElement> products=productcatalogue.Products();
		WebElement getProduct=productcatalogue.getProductByName(Productname);
		productcatalogue.addProductToCart(Productname);
		CartPage cartpage=productcatalogue.AddCart();
		
		
		//cartPage
		
		List<WebElement> cartproducts=cartpage.cartProducts();
		Boolean match=cartpage.matchedProducts(Productname);
		Assert.assertTrue(match);
		Address adr=cartpage.ClickCheckout();
		
		
		//AddressPage
		
		Confirmationpage confirmationpage=adr.Actions();
		
	
		//ConfirmationPage
		confirmationpage.comparison();
		driver.close();
		
	}
	

}
