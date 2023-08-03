package testYantraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HiddenDivisionPopup {
	@Test
	public void HiddenPopup() throws Exception
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin",Keys.TAB,"manager",Keys.ENTER);
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
		driver.findElement(By.xpath("//td[@class='selection'][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='delete button']")).click();
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//String dltmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='You are about to delete 64 tasks']"))).getText();
		WebElement element=driver.findElement(By.xpath("//div[text()='You are about to delete 64 tasks']"));
		String txt=element.getText();
		System.out.println(txt);
		
		
		
		
	}}
