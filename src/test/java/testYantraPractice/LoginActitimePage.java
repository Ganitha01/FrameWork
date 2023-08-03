package testYantraPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginActitimePage {
	@FindBy(xpath="//input[@name='username']")private WebElement usernameTxt;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement passwordTxt;
	@FindBy(xpath="//a[@id='loginButton']")private WebElement loginBtn;
	public LoginActitimePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getUsernameTxt() {
		return usernameTxt;
	}
	public WebElement getPasswordTxt() {
		return passwordTxt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * generic method for login
	 */
	public void loginOperation()
	{
		getUsernameTxt().sendKeys("admin");
		getPasswordTxt().sendKeys("manager");
		getLoginBtn().click();
	}
	

}
