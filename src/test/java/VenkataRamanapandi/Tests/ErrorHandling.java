package VenkataRamanapandi.Tests;
import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import VenkataRamanapandi.TestComponents.BaseTest;
import VenkataRamanapandi.pageobjects.ProductCatalogue;
import VenkataRamanapandi.pageobjects.Retry;
public class ErrorHandling extends BaseTest
{

	@Test(dataProvider = "getData", dataProviderClass = BaseTest.class, retryAnalyzer=Retry.class)
	public void LoginError(HashMap<String, String> input) throws IOException
	{
		
		//String Productname="ZARA COAT 3";
		
		//landingpage
		ProductCatalogue productcatalogue=landingpage.landingpage(input.get("email"),input.get("password"));
		Assert.assertNotEquals("Incorrect email or password.", landingpage.getErrorMessage());
				
		
	}

}
