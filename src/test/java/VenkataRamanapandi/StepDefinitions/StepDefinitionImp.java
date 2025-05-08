package VenkataRamanapandi.StepDefinitions;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import VenkataRamanapandi.TestComponents.BaseTest;
import VenkataRamanapandi.pageobjects.Address;
import VenkataRamanapandi.pageobjects.CartPage;
import VenkataRamanapandi.pageobjects.Confirmationpage;
import VenkataRamanapandi.pageobjects.LandingPage;
import VenkataRamanapandi.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImp extends BaseTest
{ 
	public LandingPage landingPage;
	public ProductCatalogue productcatalogue;
	public CartPage cartpage;
	public Address adr;
	public Confirmationpage confirmationpage;
	@Given("^I landed on Ecommerce Page$")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	@Given("^Login with UserName (.+) and Password (.+)$")
	public void Login_with_UserName_and_Password(String username,String password)
	{
		productcatalogue=landingpage.landingpage(username,password);

	}
	@When("^I add product (.+) to the cart$")
	public void I_add_product_to_the_cart(String productName)
	{
		List<WebElement> products=productcatalogue.Products();
		WebElement getProduct=productcatalogue.getProductByName(productName);
		
	}
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		productcatalogue.addProductToCart(productName);
		CartPage cartpage=productcatalogue.AddCart();
		List<WebElement> cartproducts=cartpage.cartProducts();
		Boolean match=cartpage.matchedProducts(productName);
		Assert.assertTrue(match);
		adr=cartpage.ClickCheckout();
		confirmationpage=adr.Actions();
	}
	@Then("{string} message is displayed.")
	public void THANKYOU_FOR_THE_ORDER_message_is_displayed(String string)
	{
		String confirmMessage=confirmationpage.comparison();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	
	@Then("Check error message {string}.")
	public void I_check_error_message(String string)
	{
		Assert.assertEquals(string, landingpage.getErrorMessage());
		driver.close();
	}
}
