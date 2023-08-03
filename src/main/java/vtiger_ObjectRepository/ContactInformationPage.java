package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement textarea;
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getTextarea() {
		return textarea;
	}
	/**
	 * this method will get contact header text and return it to caller
	 * @return
	 */
	public String getContactText()
	{
		return textarea.getText();
	}
	

}
