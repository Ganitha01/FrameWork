package Vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this is an implementation class for IRetryAnalyser interface of TestNg
 * @author ANITHA
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count=4;
	public boolean retry(ITestResult result) {
	while(count>0)
	{
		count--;
		return true;
	}
		return false;
	}

}
