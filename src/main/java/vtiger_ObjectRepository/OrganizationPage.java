package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//declaration
	@FindBy(xpath="//img[@title='Create Organization...']")private WebElement CreatOrganizationimg; 
	//initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//utilization
	public WebElement getCreatcontactimg() {
		return CreatOrganizationimg;
	}
	//business libraries
	/**
	 * this method will click on create org look up image	
	 */
	public void clickOnCreateOrgImg()
	{
		CreatOrganizationimg.click();
	}
	

}
