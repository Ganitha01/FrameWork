package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPracice {
	@Test(retryAnalyzer = Vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		System.out.println("retryanalyser");
		Assert.fail();
	}

}
