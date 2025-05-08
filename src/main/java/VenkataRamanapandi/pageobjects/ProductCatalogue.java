package VenkataRamanapandi.pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import VenkataRamanapandi.AbstractComponents.AbstractComponents;
public class ProductCatalogue extends AbstractComponents
{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(css=".offset-md-0")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement element;
	
	public List<WebElement> Products()
	{
		return products;
	}
	
	public WebElement getProductByName(String Product)
	{
		WebElement prod=Products().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(Product)).findFirst().orElse(null);
		return prod;
	}
		
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By Find1=By.cssSelector(".toast-container");
	
	public void addProductToCart(String Product)
	{
		WebElement product=getProductByName(Product);
		product.findElement(addtocart).click();
		ExplicitWaitVisible(Find1);
		ExplicitWaitInvisible(element);
		
	}
		
	
	
	
	
	
}
