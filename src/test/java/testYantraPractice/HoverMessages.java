package testYantraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HoverMessages {
	@Test
	public void hoverHandling()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.navigate().to("https://demo.actitime.com/login.do");
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element=driver.findElement(By.id("keepLoggedInCheckBox"));
		String Hovermessage=element.getAttribute("title");
		System.out.println(Hovermessage);
	}

}
