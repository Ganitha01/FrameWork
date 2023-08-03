package vtiger_ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtilities;

public class CreateNewContactPage extends WebDriverUtilities {
	@FindBy(name = "lastname")private WebElement lastnameEdt;
	@FindBy(xpath="//img[@onclick='return window.open(\"index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=\",\"test\",\"width=640,height=602,resizable=0,scrollbars=0\");']")
	private WebElement orgImg;
	@FindBy(name="search_text")private WebElement orgSearchEdt;
	@FindBy(name="search")private WebElement orgSearchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement savebtn;
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	
	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}
	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	public WebElement getOrgImg() {
		return orgImg;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	/**
	 * this method will create new contact with mandatory information
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		savebtn.click();
	}
	/**
	 * this method will create new contact with organization name
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		orgImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		savebtn.click();
	}
	
}





