/**
 * 
 */
package Listenersadd;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Extentreports.LeaveReports;

public class Listenersrepo implements ITestListener{

	ExtentReports extent=LeaveReports.extentrepo();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Successfully executed the test case");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	test.fail(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	extent.flush();
	}

}
