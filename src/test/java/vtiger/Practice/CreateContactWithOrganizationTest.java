package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import Vtiger.GenericUtilities.ExccelFileUtility;
import Vtiger.GenericUtilities.JavaUility;
import Vtiger.GenericUtilities.ProperyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_ObjectRepository.ContactInformationPage;
import vtiger_ObjectRepository.ContactsPage;
import vtiger_ObjectRepository.CreateNewContactPage;
import vtiger_ObjectRepository.CreateNewOrgPage;
import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.LoginPage;
import vtiger_ObjectRepository.OrgInformationPage;
import vtiger_ObjectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest {
	public static void main(String[] args) throws Exception {
	
	//create the object for generic utilities
ProperyFileUtility putil=new ProperyFileUtility();
ExccelFileUtility eutil=new ExccelFileUtility();
JavaUility jutil=new JavaUility();
WebDriverUtilities wutil=new WebDriverUtilities();
//read all the necessary data
String BROWSER=putil.readDataFromPropertyFile("browser");
String URL=putil.readDataFromPropertyFile("url");
String USERNAME=putil.readDataFromPropertyFile("username");
String PASSWORD=putil.readDataFromPropertyFile("password");
String ORGNAME=eutil.readDataFromExcel("Organization", 1, 2)+jutil.getRandomNumber();
String LASTNAME=eutil.readDataFromExcel("Contact", 1, 2);
//launch the browser
WebDriver driver=null;
ChromeOptions option = new ChromeOptions();
option.addArguments("--remote-allow-origins=*");
if(BROWSER.equalsIgnoreCase("chrome"))
{WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver(option);
}
else if(BROWSER.equalsIgnoreCase("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}
else
{
	System.out.println("invalid browser name");
}
wutil.maximizeWindow(driver);
wutil.waitForPageLoad(driver);
driver.get(URL);
//login operation

LoginPage lp=new LoginPage(driver);
lp.loginToApplication(USERNAME, PASSWORD);
//navigate to organization link
HomePage hp=new HomePage(driver);
hp.clickOnOrganizationLink();
//click on create organization lookup image
OrganizationPage op=new OrganizationPage(driver);
op.clickOnCreateOrgImg();
//create organization with mandatory fields
CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
cnop.createNewOrganization(ORGNAME);
Thread.sleep(3000);
//validatation for Organization
/*String ORGHEADER=driver.findElement(By.className("dvHeaderText")).getText();*/
OrgInformationPage oip=new OrgInformationPage(driver);
String ORGHEADER=oip.getOrnHeader();
if(ORGHEADER.contains(ORGNAME))
{
	System.out.println(ORGHEADER+"-----organization created");
}
else
{
	System.out.println("----------organation creation failed---------");
}
Thread.sleep(3000);
//navigate to contacts link
/*driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();*/
hp.clickOnContactsLink();
//click on create contact lookup image
ContactsPage cp=new ContactsPage(driver);
cp.clickOnCreateNewContact();
/*driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();*/
//create new contact
/*driver.findElement(By.name("lastname")).sendKeys(LASTNAME);*/
CreateNewContactPage cncp=new CreateNewContactPage(driver);
cncp.createNewContact(driver, LASTNAME, ORGNAME);
Thread.sleep(4000);
//wutil.takeScreenShot(driver, "screenshot1");
/*driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
wutil.switchToWindow(driver, "Accounts");
driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
driver.findElement(By.name("search")).click();
driver.findElement(By.linkText(ORGNAME)).click();
wutil.switchToWindow(driver, "Contacts");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
//validation for contacts
ContactInformationPage cip=new ContactInformationPage(driver);
String CONHEADER=cip.getContactText();
/*String CONHEADER=driver.findElement(By.className("dvHeaderText")).getText();*/
if(CONHEADER.contains(LASTNAME))
{
	System.out.println("----the test case is passed----");
}
else
{
	System.out.println("--test case is failed----");
}
//logout
hp.logoutOfApp(driver);
/*WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
wutil.mouseHoverAction(driver, element);
driver.findElement(By.linkText("Sign Out")).click();*/
System.out.println("signout successfully");
driver.quit();





		

	}
}