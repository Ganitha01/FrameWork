package training;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTales1 {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
	WebDriver driver=new ChromeDriver(option);
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String countryName="America";
	boolean flag=false;
	List<WebElement> teams=driver.findElements(By.xpath("//tbody//tr//td[2]/span[2]"));
	for(WebElement E:teams)
	{
		String text=E.getText();
		if(text.equalsIgnoreCase(countryName))
		{
			System.out.println("country is present");
			flag=true;
			break;
		}
		
	}
	if(!flag)
	{
		System.out.println("country is not present");
	}

	}

}
