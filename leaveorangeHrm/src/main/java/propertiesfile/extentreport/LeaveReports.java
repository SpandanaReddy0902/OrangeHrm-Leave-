package Extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LeaveReports {
 
	static ExtentReports extent;
	
	public static  ExtentReports extentrepo() {
		
	
		ExtentSparkReporter reporter=new ExtentSparkReporter("");
		
		reporter.config().setReportName("OrangeHrm Leave Automation");
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		return extent;
		
	}
}
