package training;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJet {

	public static void main(String[] args) throws Exception {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		option.addArguments("--disable-notifications");
		//navigate to applicatio
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//driver.switchTo().alert().dismiss();
		//select from city
		String destcity="goi";
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::div[.='From' and @class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys("hy");
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys(destcity);
		/*Date date=new Date();//System.out.println(date);
		String d[]=date.toString().split(" ");
		String day=d[0];
		String month=d[1];
		String currentdate=d[2];
		String year=d[5];
		String traveldate=day+" "+month+" "+currentdate+" "+year;*/
		String monthyear="May 2023";
		String date="15";
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj']//div[.='"+monthyear+"']/../following-sibling::div[@class='css-1dbjc4n']/descendant::div[@data-testid='undefined-calendar-day-"+date+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti']/descendant::div[@class='css-1dbjc4n']")).click();
		
		//driver.close();
	}

}
