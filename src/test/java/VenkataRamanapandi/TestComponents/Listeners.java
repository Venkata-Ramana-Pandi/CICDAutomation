package VenkataRamanapandi.TestComponents;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import VenkataRamanapandi.Resources.ExtentReportsNg;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener
{

	ExtentReports extent=ExtentReportsNg.TestReports();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	ExtentTest Test;
	@Override
	public void onTestStart(ITestResult result)
	{
		
		ITestListener.super.onTestStart(result);
		Test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(Test);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ITestListener.super.onTestSuccess(result);
		Test.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		ITestListener.super.onTestFailure(result);
		extentTest.get().fail(result.getThrowable());
		//on test failure take screenshot and attach screenshot
		// for that go and read screenshot utility in BaseTest Class
		//to read that screenshot method i need to make cureent class in to sub class of Basetest or initilise an object
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String file = null;
		try {
			file = takeScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Test.addScreenCaptureFromPath(file,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
	
	
	
	
}
