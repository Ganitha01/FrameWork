package training;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webTables {

	public static void main(String[] args) {
ChromeOptions option=new ChromeOptions();
option.addArguments("--remote-allow-origins=*");
WebDriver driver=new ChromeDriver(option);
driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
List<WebElement> countryNames=driver.findElements(By.xpath("//tbody//tr//td[2]/span[2]"));
List<WebElement> matches=driver.findElements(By.xpath("//tbody//tr//td[3]"));
for(int i=1;i<countryNames.size();i++)
{
	System.out.println(countryNames.get(i).getText()+"-"+matches.get(i).getText());
}
	}

}
