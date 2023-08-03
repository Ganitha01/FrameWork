package vtiger.Practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtilities.ProperyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtilities;
//import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_ObjectRepository.LoginPage;

public class POMClassPractice {
public static void main(String[] args) throws Exception {
/*WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();*/
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(option);
	WebDriverUtilities wutil=new WebDriverUtilities();
	ProperyFileUtility putil=new ProperyFileUtility();
	String USERNAME=putil.readDataFromPropertyFile("username");
	String PASSWORD=putil.readDataFromPropertyFile("password");
			
	wutil.waitForPageLoad(driver);
	driver.get(putil.readDataFromPropertyFile("url"));
	LoginPage lp=new LoginPage(driver);
	lp.getUsernameEdt().sendKeys(USERNAME);
	lp.getPasswordEdt().sendKeys(PASSWORD);
	lp.getSubmitBtn().click();
	//lp.loginToApplication(USERNAME, PASSWORD);
			
	

	}

}
