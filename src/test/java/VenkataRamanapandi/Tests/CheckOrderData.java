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
import VenkataRamanapandi.Data.DataReader;
import VenkataRamanapandi.TestComponents.BaseTest;
import VenkataRamanapandi.pageobjects.Address;
import VenkataRamanapandi.pageobjects.CartPage;
import VenkataRamanapandi.pageobjects.Confirmationpage;
import VenkataRamanapandi.pageobjects.LandingPage;
import VenkataRamanapandi.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.DataProvider;


public class CheckOrderData extends BaseTest 
{
 
	@Test(dataProvider="getData")
	public void SubmitMethod(HashMap<String,String> input) throws IOException
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
		confirmationpage.comparison();
		
		
	}
	
	
	
	//	HashMap<String,String> map1=new HashMap<>();
	//	map1.put("email", "pvramana1819@gmail.com");
	//  map1.put("password", "Venkat@1");
	//  map1.put("productname","ZARA COAT 3");
		
	//	HashMap<String,String> map2=new HashMap<>();
	//	map2.put("email", "pvramana1819@gmail.com");
	//	map2.put("password", "Venkat@1");
	//	map2.put("productname","ADIDAS ORIGINAL");
	    
	// DataReader dr=new DataReader();
	//	return new Object[][]
	//   	{
	//        {map1},
	//        {map2}
	//    };
		
	
	@DataProvider
	public Object[][] getData() throws IOException {
	    DataReader dr = new DataReader();
	    List<HashMap<String, String>> data = dr.reader();
	    Object[][] result = new Object[data.size()][1];
	    for (int i = 0; i < data.size(); i++) {
	        result[i][0] = data.get(i);
	    }
	    return result;
	}

}
