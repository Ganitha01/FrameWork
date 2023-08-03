package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Vtiger.GenericUtilities.WebDriverUtilities;

public class CreateNewOrgPage extends WebDriverUtilities{
	@FindBy(name="accountname")private WebElement orgnameEdt;
	@FindBy(name="industry")private WebElement industrydropdown;
	@FindBy(xpath="//select[@name='accounttype']")private WebElement typeDropdown;
	@FindBy(css = "input[title='Save [Alt+S]']")private WebElement saveBtn;
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}
	public WebElement getTypeDdown() {
		return typeDropdown;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * this method will create organization with mandatory information
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{orgnameEdt.sendKeys(ORGNAME);
	saveBtn.click();
	}
	/**
	 * this method will create orgnization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY)
	{
		orgnameEdt.sendKeys(ORGNAME);
		industrydropdown.click();
		handleDropdown(industrydropdown,INDUSTRY);
		saveBtn.click();
		
	}
	/**
	 * this method will create orzanization with industrydropdown and type drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY,String TYPE)
	{orgnameEdt.sendKeys(ORGNAME);
	industrydropdown.click();
	handleDropdown(industrydropdown,INDUSTRY);
	typeDropdown.click();
	handleDropdown(industrydropdown,TYPE);
	saveBtn.click();
		
	}
	
	
	
	
	

}
