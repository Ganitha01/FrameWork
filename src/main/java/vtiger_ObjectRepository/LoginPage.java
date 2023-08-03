package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
// rule-1 create a separate POM class for every webpage
	//rule-2 identify all the web elements using annotations
	//@FindBy(name = "user_name")private WebElement usernameEdt;
	@FindBy(xpath="//input[@name='user_name']")private WebElement usernameEdt;
	@FindBy(name="user_password")private WebElement passwordEdt;
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")}) WebElement submitBtn;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	/**
	 * Business library -generic methods-project specific
	 * this method will login to the application
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}
	
	
	
	
	
	
	
	
}
