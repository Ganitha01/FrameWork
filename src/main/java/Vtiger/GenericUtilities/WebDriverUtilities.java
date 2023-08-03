package Vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic method related to web driver actions
 * @author ANITHA
 *
 */
public class WebDriverUtilities {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the window
	 * @param driver
	 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * this method will wait for 20sec for the page load
 * @param driver
 */
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
}


/**
 * this method will wait until the particular web element is visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method will wait until a particular web element is clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * this method will handle dropdown by index
 * @param Element
 * @param index
 */
public void handleDropdown(WebElement Element,int index)
{
	Select sel=new Select(Element);
	sel.selectByIndex(index);
}
/**
 * his method will handle dropdown by value
 * @param Element
 * @param value
 */
public void handleDropdown(WebElement Element,String value)
{
	Select sel=new Select(Element);
	sel.selectByValue(value);
}
/**
 * this method will handle dropdown by visible text
 * @param text
 * @param Element
 */
public void handleDropdown(String text,WebElement Element)
{
	Select sel=new Select(Element);
	sel.selectByVisibleText(text);
}
/**
 * this method will perform mouse hover action on a webelement
 * @param driver
 * @param Element
 */
public void mouseHoverAction(WebDriver driver,WebElement Element)
{
	Actions act=new Actions(driver);
	act.moveToElement(Element).perform();
}
/**
 * This method will perform rightclick anywhere on the page
 * @param driver
 */
public void rigthClickAction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
	
}
/**
 * this method will perform rightclick on particular web element
 * @param driver
 * @param Element
 */
public void rigthClickAction(WebDriver driver,WebElement Element)
{
	Actions act=new Actions(driver);
	act.contextClick(Element).perform();
	
}
/**
 * this method will perform double click anywhere on the page
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
	
}
/**
 * this method will perform double click on particular web element
 * @param driver
 * @param Element
 */
public void doubleClickAction(WebDriver driver,WebElement Element)
{
	Actions act=new Actions(driver);
	act.doubleClick(Element).perform();
	
}
/**
 * this method will perform drag and drop from one element to another
 * @param driver
 * @param srcElement
 * @param dstElement
 */
public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement dstElement)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(srcElement, dstElement).perform();
	
}
/**
 * this method will press the enterKey
 * @throws AWTException 
 */
public void pressEnterKey() throws AWTException
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
}
/**
 * this method will release the enter key
 * @throws AWTException
 */
public void releaseEnterKey() throws AWTException
{
	Robot r=new Robot();
	r.keyRelease(KeyEvent.VK_ENTER);
	
}
/**
 * this method will handle frames with index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * this method will handle frames with nameOrId
 * @param driver
 * @param nameOrId
 */
public void handleFrame(WebDriver driver,String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}
/**
 * this method will handle frames with webElement
 * @param driver
 * @param nameOrId
 */
public void handleFrame(WebDriver driver,WebElement Element)
{
	driver.switchTo().frame(Element);
}
/**
 * this method will switch to parent frame
 * @param driver
 */
public void handleParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
	
}
/**
 * this method will switch to default frame
 * @param driver
 */
public void handleDefaultFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * this method will accept alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * this method will dismiss alert popup
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * this method will capture and return the alert text
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
/**
 * this metho will taj the screenshot and save it in screenshot folder
 * @param driver
 * @param screenshotName
 * @return
 * @throws IOException
 */
public String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
{TakesScreenshot ts=(TakesScreenshot)driver;
File src=ts.getScreenshotAs(OutputType.FILE);
File dst=new File(".\\screenshot\\",screenshotName+".png");
FileUtils.copyFile(src, dst);//common io dependency
return dst.getAbsolutePath();// used in extend reports
}
/**
 * This method switch to window based on partial window title
 * @param driver
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver,String partialWinTitle)
{
	// step-1 capture all the window IDs
	Set<String> winIds=driver.getWindowHandles();
	
	//step-2 use for each loop and navigate to each window
	for(String win:winIds)
	{
		//step-3 capture the title of each window
		String currentTitle=driver.switchTo().window(win).getTitle();
		
		//step-4 compare the current title with partial window title
		if(currentTitle.contains(partialWinTitle))
				{
			break;
				}
	}
}
public void scrollActions(WebDriver driver,WebElement Element)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	int y=Element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", Element);
}




















































































}
