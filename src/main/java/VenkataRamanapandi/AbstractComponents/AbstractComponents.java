package VenkataRamanapandi.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import VenkataRamanapandi.pageobjects.CartPage;

public class AbstractComponents
{
		
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement cart;
	
	public CartPage AddCart()
	{
		cart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
			
	public void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void ExplicitWaitVisible(By FindBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void Waitvisible(WebElement element)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void ExplicitWaitInvisible(WebElement element)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}


}
