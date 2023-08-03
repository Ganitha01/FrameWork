package testYantraPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WindowPopup {
	@Test
	public void windowHandling() throws Exception
	{ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
	WebElement element=driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
	element.sendKeys("i phone11");
	element.submit();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[text()='APPLE iPhone 11 (Black, 128 GB)']")).click();
	//String parentid=driver.getWindowHandle();
	String partialText="apple-iphone-11-black-128-gb";
	Set<String> chaildId=driver.getWindowHandles();
	for(String window:chaildId)
	{String currenId=driver.switchTo().window(window).getTitle();
	System.out.println(currenId);
		if(currenId.contains(partialText))
		{
			driver.switchTo().window(window);
		}
		
	}
	String text=driver.findElement(By.xpath("//span[text()='APPLE iPhone 11 (Black, 128 GB)']")).getText();
	System.out.println(text);
	driver.close();
		
	}

}
