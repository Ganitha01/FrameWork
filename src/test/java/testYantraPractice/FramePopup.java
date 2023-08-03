package testYantraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FramePopup {
	
@Test
public void framehandling()
{
ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		driver.findElement(By.xpath("//a[text()='Frames'][1]")).click();
		WebElement element=driver.findElement(By.xpath("//Iframe[@name='packageListFrame']"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//a[@href='org/openqa/selenium/package-frame.html']")).click();
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='All classes and interfaces (except non-static nested types)']")));
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		driver.switchTo().defaultContent();
		driver.quit();
		
}
}
