package vtiger.Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.ExccelFileUtility;
import Vtiger.GenericUtilities.JavaUility;
import Vtiger.GenericUtilities.ProperyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_ObjectRepository.CreateNewOrgPage;
import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.LoginPage;
import vtiger_ObjectRepository.OrganizationPage;

public class CreateMultipleOrgTest {
	ExccelFileUtility eutil=new ExccelFileUtility();
	JavaUility jutil=new JavaUility();
	@Test(dataProvider = "OrgWithIndustry")
	public void createOrgTest(String ORG,String INDUSTRY) throws Exception
	{
	//step-1 Create the object of generic utilities
		ProperyFileUtility putil=new ProperyFileUtility();
		WebDriverUtilities wutil=new WebDriverUtilities();
		//step-2 read all the required data
		String BROWSER=putil.readDataFromPropertyFile("browser");
		String USERNAME=putil.readDataFromPropertyFile("username");
		String PASSWORD=putil.readDataFromPropertyFile("password");
		String URL=putil.readDataFromPropertyFile("url");
		String ORGNAME=ORG+jutil.getRandomNumber();
		WebDriver driver=null;
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		//LOgin operation
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		//navigate to organizaions link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
	//click on create organization lookup
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		//create Organization with madatory fields
		CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		//validation part
		String ORGHEADER=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println("the test case passed");
		}
		else
		{
			System.out.println("failed");
		}
		//logout operation
		WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.mouseHoverAction(driver, element);
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		System.out.println("sign out successfully");
		driver.quit();
	}
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws Exception
	{
		Object[][] data=eutil.readDataFromExcelToDatoProvider("DataProviderOrg");
		return data;
	}
}
