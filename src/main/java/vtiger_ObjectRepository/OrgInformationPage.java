package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInformationPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")private WebElement orgtextarea;
	public OrgInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgtextarea() {
		return orgtextarea;
	}
	public String getOrnHeader()
	{
		return orgtextarea.getText();
	}

}
