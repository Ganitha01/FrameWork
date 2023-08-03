package testYantraPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class BrowserControlMethods {
	//@Test
	public void driverMethods()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().setPosition(new Point(200,300));//we have to create an object for Point(mport org.openqa.selenium.Point)i have used the shortcut
		driver.manage().window().setSize(new Dimension(200,300));//we have to create an object for Dimentions(import org.openqa.selenium.Dimension;),i have used th shortcut for object creation
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com/");
		driver.get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		driver.navigate().back();
		System.out.println("navigate to flipkart successfull");
		driver.navigate().forward();
		System.out.println("navigate to selenium dev successfull");
		driver.navigate().refresh();
		driver.navigate().back();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	WebElement element=driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
	element.sendKeys("i phone11");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	//System.out.println(driver.getPageSource());
		
	}
	@Test
	public void webelementMethods()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element=driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
		element.sendKeys("i phone11");
		System.out.println(element.getText());
		System.out.println(element.getAttribute("title"));//get the value of given attribute
		System.out.println(element.getLocation());
		System.out.println(element.getSize());
		System.out.println(element.getTagName());
		element.submit();
		WebElement element1=driver.findElement(By.xpath("//span[text()='Showing 1 – 24 of 697 results for \"']"));
		System.out.println(element1.isDisplayed());
		System.out.println(element1.isEnabled());
		System.out.println(element.isSelected());
		
		
		
		
		
		
		
		
		
		
		
	}

}
