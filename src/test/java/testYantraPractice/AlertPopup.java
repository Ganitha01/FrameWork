package testYantraPractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopup {
	@Test
	public void alertpopup()
	{
	//ChromeOptions option=new ChromeOptions();
	//option.addArguments("--remote-allow-origins=*");
		WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.get("https://demo.actitime.com/login.do");
	driver.manage().window();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin",Keys.TAB,"manager",Keys.ENTER);
	driver.findElement(By.xpath("(//div[@class='menu_icon'])[2]")).click();
	driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
	driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("abcd");
	driver.findElement(By.xpath("//input[@value='      Cancel      ']")).click();
	Alert alt=driver.switchTo().alert();
	System.out.println(alt.getText());
	alt.dismiss();
	driver.close();
	
	
	
	}
}
