package VenkataRamanapandi.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import VenkataRamanapandi.AbstractComponents.AbstractComponents;
public class Confirmationpage extends AbstractComponents
{
	WebDriver driver;
	public Confirmationpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	@FindBy(css=".hero-primary")
	WebElement message;
	
	public String comparison()
	{
		String msg=message.getText();	
		return msg;
		
	}
	
	
		
}
