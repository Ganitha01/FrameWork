package Vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Practice {
	int a=10;
	public int sample()
	{
		try
		{
			return 5;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 5;
	}
	WebDriver driver=new ChromeDriver();
	JavaScriptUtility jutil=new JavaScriptUtility(driver);

	
}
