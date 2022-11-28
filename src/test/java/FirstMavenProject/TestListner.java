package FirstMavenProject;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListner implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	test=reports.startTest(result.getMethod().getMethodName());	
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("*************Test case is passed**************");
	test.log(LogStatus.PASS,"Test case is Success");
	reports.endTest(test);
	
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*************Test case is Failed**************");
		test.log(LogStatus.FAIL,result.getThrowable());
	reports.endTest(test);
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		reports = new ExtentReports("C:\\Users\\LENOVO\\eclipse-workspace\\com.Insta\\reports"+"\\ExtentReportResults.html");
		reports.loadConfig(new File("C:\\Users\\LENOVO\\eclipse-workspace\\com.Insta\\config-report.xml"));
	
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
	}

	
	
	
	
	
	
	
	
}
