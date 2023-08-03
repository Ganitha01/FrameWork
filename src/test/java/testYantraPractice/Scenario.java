package testYantraPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Scenario {
	@Test
	public void flipkart()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element=driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		element.sendKeys("i phone");
		element.submit();
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 11 (White, 128 GB)']")).click();
		String parentId=driver.getWindowHandle();
		String partialtext="APPLE iPhone 11 (White, 128 GB)";
	Set<String> allIds=driver.getWindowHandles();
	for(String window:allIds)
	{
	String currentId=driver.switchTo().window(window).getTitle();
	if(currentId.contains(partialtext))
		driver.switchTo().window(window);
	}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Midnight, 128 GB)']")).click();
		Set<String> allIds1=driver.getWindowHandles();
		for(String window:allIds1)
		{
			String currentId=driver.switchTo().window(window).getTitle();
			if(currentId.contains(partialtext))
				driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		driver.findElement(By.xpath("//a[text()='APPLE iPhone 13 (Midnight, 128 GB)']/../../../following-sibling::div/div/div/following-sibling::div")).click();
		
		
		
	}

}
