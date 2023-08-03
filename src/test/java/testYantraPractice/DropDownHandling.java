package testYantraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownHandling {
	@Test
	public void listBoxHandling()
	{
		
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	ChromeDriver driver=new ChromeDriver(option);
	driver.get("https://www.opencart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	//driver.findElement(By.xpath("//button[@class='navbar-toggle collapsed']")).click();
	driver.findElement(By.xpath("//a[@class='btn btn-black navbar-btn']")).click();
	WebElement element=driver.findElement(By.xpath("//select[@id='input-country']"));
	Select s=new Select(element);
	s.selectByVisibleText("Ghana");
	s.deselectByVisibleText("Ghana");
	s.selectByVisibleText("India");
	driver.quit();
	
	}

}
