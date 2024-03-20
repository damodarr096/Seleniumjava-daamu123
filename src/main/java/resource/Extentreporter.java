package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreporter {
	
	public static ExtentReports extent;
	public static ExtentReports getextentreport() {
		
		String extentreportpath= System.getProperty("user.dir")+"\\reports\\extentreport.html";		
		ExtentSparkReporter  reporter= new ExtentSparkReporter(extentreportpath);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Automation labs Reports");
		
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("selenium version", "4.16.1");
		extent.setSystemInfo("Tested By", "Damodar");
		
		return extent;
		
		
	}

}
