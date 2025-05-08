package VenkataRamanapandi.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VenkataRamanapandi.AbstractComponents.AbstractComponents;
public class LandingPage extends AbstractComponents
{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	//WebElement uname=driver.findElement(By.cssSelector("[id='userEmail']"));
		
	@FindBy(css="#userEmail")
	WebElement userEmail;
		
	@FindBy(css="#userPassword")
	WebElement userPassword;
		
	@FindBy(name="login")
	WebElement userlogin;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement getErrorMessage;
		
	//link
	public void link()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	
	
	
	public String getErrorMessage()
	{
		Waitvisible(getErrorMessage);
		return getErrorMessage.getText();
	}
	
	//userdetails
	
	public ProductCatalogue landingpage(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		userlogin.click();
		ProductCatalogue productcatalogue=new ProductCatalogue(driver);
		return  productcatalogue;
	}
		
}
