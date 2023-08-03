package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")private WebElement contactlink;
	@FindBy(xpath="(//a[text()='Organizations'])[1]")private WebElement organizationlink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")private WebElement administratorimg;
	@FindBy(xpath="//a[text()='Sign Out']")private WebElement signoutlink;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	public WebElement getOrganizationlink() {
		return organizationlink;
	}
	public WebElement getAdministratorimg() {
		return administratorimg;
	}
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	//business libraries
	/**
	 * this method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactlink.click();
	}
	/**
	 * this method will click on Organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationlink.click();
	}
	/**
	 * this method will perform logout action
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, administratorimg);
		signoutlink.click();
	}

}















