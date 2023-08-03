package Vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.LoginPage;

public class BaseClass {
	public ProperyFileUtility putil=new ProperyFileUtility();
	public ExccelFileUtility eutil=new ExccelFileUtility();
	public JavaUility jutil=new JavaUility();
	public WebDriverUtilities wutil=new WebDriverUtilities();
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfiguration()
	{
		System.out.println("------database connection successfull-----");
	}
	//@Parameters("BROWSER")
	//@BeforeTest we use it in test level i.e for parallel execution to avoid number of timer Browser launching
	@BeforeClass(alwaysRun = true)
	public void bcConfiguration(/*String BROWSER*/) throws IOException
	{
		String BROWSER=putil.readDataFromPropertyFile("browser");
		String URL=putil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		System.out.println("----chrome launched successfully------");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("----firefox launched successfully------");
		}
		sDriver=driver;//this is for listeners
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
	}
	@BeforeMethod(alwaysRun = true)
	public void bmConfiguration() throws IOException
	{
		String USERNAME=putil.readDataFromPropertyFile("username");
		String PASSWORD=putil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		System.out.println("-----login to the application successfull-------");
	}
	@AfterMethod(alwaysRun = true)
	public void amConfiguration()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("-----logout to the application successfull-------");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfiguration()
	{
		driver.quit();
		System.out.println("---closed the browser successfully------");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfiguration()
	{
		System.out.println("---------database closed successfully-----");
	}

}
