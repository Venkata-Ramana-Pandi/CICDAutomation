package VenkataRamanapandi.pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import VenkataRamanapandi.AbstractComponents.AbstractComponents;
public class CartPage extends AbstractComponents
{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cart;

	public List<WebElement> cartProducts()
	{
		return cart;
	}
	
	public Boolean matchedProducts(String Productname) 
	{
		Boolean match=cartProducts().stream().anyMatch(s->s.getText().equals(Productname));
		return match;
	}
	
	public Address ClickCheckout()
	{
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Address adr=new Address(driver);
		return adr;
	}
		

	

}
