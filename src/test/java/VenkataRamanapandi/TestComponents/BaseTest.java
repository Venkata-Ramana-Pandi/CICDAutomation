package VenkataRamanapandi.TestComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import VenkataRamanapandi.Data.DataReader;
import VenkataRamanapandi.pageobjects.Address;
import VenkataRamanapandi.pageobjects.CartPage;
import VenkataRamanapandi.pageobjects.Confirmationpage;
import VenkataRamanapandi.pageobjects.LandingPage;
import VenkataRamanapandi.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {


	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException

	{
		// properties class
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\pandi\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\VenkataRamanapandi\\Resources\\GlobalsData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		

		if (browserName.toLowerCase().contains("chrome")) 
		{
		    WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    if(browserName.toLowerCase().contains("headless"))
		    {
		        options.addArguments("headless");
		    }
		    driver = new ChromeDriver(options);
		    driver.manage().window().setSize(new Dimension(1440, 900));
		}

		
		else if (browserName.equalsIgnoreCase("firefox"))
		{

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		} 
		
		else if (browserName.equalsIgnoreCase("edge")) 
		{

			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			driver = new EdgeDriver(options);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

		}
		@BeforeMethod
		public LandingPage launchApplication() throws IOException
		{
			driver=initializeDriver();
			landingpage=new LandingPage(driver);
			landingpage.link();	
			return landingpage;
		}
	
		@AfterMethod
		public void close()
		{
			driver.close();
		}

		@DataProvider(name = "getData")
		public Object[][] reader() throws IOException
		{
			//read json file to string
			String jsoncontent=FileUtils.readFileToString(new File("C:\\Users\\pandi\\eclipse-workspace\\SeleniumFrameworkDesign"
					+ "\\src\\main\\java\\VenkataRamanapandi\\Resources\\Data.json"), StandardCharsets.UTF_8);
			//now convert this string format to hashmap format by using data bind dependency
			
			ObjectMapper mapper=new ObjectMapper();
			List<HashMap<String,String>> data=mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){} );
			return new Object[][]  {{data.get(0)},{data.get(1)}};
		}
		
		public String takeScreenShot(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
			FileUtils.copyFile(src, file);
			return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
			
		}
	
}
