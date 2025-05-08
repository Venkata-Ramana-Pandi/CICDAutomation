package VenkataRamanapandi.pageobjects;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VenkataRamanapandi.AbstractComponents.AbstractComponents;
public class Address extends AbstractComponents
{

	WebDriver driver;
	public Address(WebDriver driver)
	{ 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	By compare=By.cssSelector(".form-group");
	
	
	@FindBy(css=".ta-results button:last-of-type")
	WebElement DropdownCompare;
	
	@FindBy(css=".action__submit")
	WebElement FinalClick;
	

	By Find4=By.cssSelector(".ta-results");
	By Find5=By.cssSelector(".action__submit");
	
	
	public Confirmationpage Actions() 
	{
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector(".form-group")), "India").build().perform();
		ExplicitWaitVisible(Find4);
		DropdownCompare.click();
		ExplicitWaitVisible(Find5);
		FinalClick.click();
		Confirmationpage confirmationpage=new Confirmationpage(driver);
		return confirmationpage;
		
	}
	
	
}
