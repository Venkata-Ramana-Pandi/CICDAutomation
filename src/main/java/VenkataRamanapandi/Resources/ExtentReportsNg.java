package VenkataRamanapandi.Resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNg
{

	public static ExtentReports extent;
	public static ExtentReports TestReports()
	{
	String path=System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Test Reports");
	reporter.config().setReportName("Web Automation Reports");	
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Ramana");
	return extent;
	
	}
	
	
}
