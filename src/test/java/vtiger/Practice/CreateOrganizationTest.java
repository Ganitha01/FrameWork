package vtiger.Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtilities.ExccelFileUtility;
import Vtiger.GenericUtilities.JavaUility;
import Vtiger.GenericUtilities.ProperyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
public static void main(String[] args) throws Exception {
	//step-1 Create the object of generic utilities
	ExccelFileUtility eutil=new ExccelFileUtility();
	JavaUility jutil=new JavaUility();
	ProperyFileUtility putil=new ProperyFileUtility();
	WebDriverUtilities wutil=new WebDriverUtilities();
	//step-2 read all the required data
	String BROWSER=putil.readDataFromPropertyFile("browser");
	String USERNAME=putil.readDataFromPropertyFile("username");
	String PASSWORD=putil.readDataFromPropertyFile("password");
	String URL=putil.readDataFromPropertyFile("url");
	String ORGNAME=eutil.readDataFromExcel("Organization", 1, 2)+jutil.getRandomNumber();
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
		System.out.println("----Firefox launched successfully------");
	}
	else
	{
		System.out.println("invalid browser name");
	}
	wutil.maximizeWindow(driver);
	wutil.waitForPageLoad(driver);
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD,Keys.TAB,Keys.ENTER);
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
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
}
