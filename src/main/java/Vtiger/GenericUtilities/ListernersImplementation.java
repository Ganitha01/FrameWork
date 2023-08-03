package Vtiger.GenericUtilities;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernersImplementation implements ITestListener  {

	public void onTestStart(ITestResult result) {
		String methodename=result.getMethod().getMethodName();
		System.out.println(methodename+"===TEst script execution starts===");
	}

	public void onTestSuccess(ITestResult result) {
		String methodename=result.getMethod().getMethodName();
		System.out.println(methodename+"===TEst script execution PASSED====");
	}

	public void onTestFailure(ITestResult result){
		WebDriverUtilities wutil=new WebDriverUtilities();
		String methodename=result.getMethod().getMethodName();
		System.out.println(methodename+"===TEst script execution FAILD===");
		System.out.println(result.getThrowable());//this method will print the exception
		String screenshotname=methodename+"-"+new JavaUility().getSystemDateInFormat();
		try {
			wutil.takeScreenShot(BaseClass.sDriver, screenshotname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodename=result.getMethod().getMethodName();
		
		System.out.println(methodename+"===TEst script execution SKIPPED===");
		System.out.println(result.getThrowable());//this method will print the exception
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {											//report-07-04-2023-22-18.html
		ExtentSparkReporter htmlreporter=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUility().getSystemDateInFormat()+".html");
		htmlreporter.config().setDocumentTitle("Vtiger execution report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Automation execution report");	
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlreporter);
		System.out.println("===Suite level execution starts===");
	}

	public void onFinish(ITestContext context) {
		System.out.println("===Suite level execution ends===");
	}
	

}
