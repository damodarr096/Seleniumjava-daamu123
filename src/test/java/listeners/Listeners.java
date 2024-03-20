package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.Extentreporter;

public class Listeners extends Base implements ITestListener {
	WebDriver driver;
	ExtentReports extentreport = Extentreporter.getextentreport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread= new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
	extentTest = extentreport.createTest(result.getName()+"  excution  started");
	extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTestThread.get().log(Status.PASS, result.getName()+"  got  passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTestThread.get().fail(result.getThrowable());
		String testMethodname=result.getName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String screenshotpath = takeScreenShot(testMethodname, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotpath,testMethodname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}

}
