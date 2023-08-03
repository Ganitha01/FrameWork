package training;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Olympics {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	List<WebElement> countries=driver.findElements(By.xpath("//section[@class='Gridstyles__GridContainer-sc-1p7u4tu-0 blbIQR medals__GridWrapper-sc-15nhwt9-1 YNlUE']/descendant::span[@data-cy='country-name']"));
	List<WebElement> GoldMedals=driver.findElements(By.xpath("//section[@class='Gridstyles__GridContainer-sc-1p7u4tu-0 blbIQR medals__GridWrapper-sc-15nhwt9-1 YNlUE']/descendant::span[@data-cy='country-name']/../following-sibling::div[@title='Gold']/span[@data-cy='medal-main']"));
	List<WebElement> silverMedals=driver.findElements(By.xpath("//section[@class='Gridstyles__GridContainer-sc-1p7u4tu-0 blbIQR medals__GridWrapper-sc-15nhwt9-1 YNlUE']/descendant::span[@data-cy='country-name']/../following-sibling::div[@title='Silver']/span[@data-cy='medal-main']"));
	List<WebElement> bronzeMedals=driver.findElements(By.xpath("\"//section[@class='Gridstyles__GridContainer-sc-1p7u4tu-0 blbIQR medals__GridWrapper-sc-15nhwt9-1 YNlUE']/descendant::span[@data-cy='country-name']/../following-sibling::div[@title='Silver']/span[@data-cy='medal-main']"));
	List<WebElement> totalMedals=driver.findElements(By.xpath(""));
	}

}
