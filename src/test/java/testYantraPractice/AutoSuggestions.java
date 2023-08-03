package testYantraPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AutoSuggestions {
@Test
public void autosuggestions() throws Exception
{
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	ChromeDriver driver=new ChromeDriver(option);
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Thread.sleep(4000);
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	Thread.sleep(3000);
	WebElement element=driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
	element.sendKeys("mobile phone");
	List<WebElement> elementlist=driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']//span"));
	for(WebElement list:elementlist)
	{
		System.out.println(list.getText());
	}
}
}
