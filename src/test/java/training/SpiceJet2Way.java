package training;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJet2Way {

	public static void main(String[] args) throws Exception {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		//WebDriver driver=new FirefoxDriver();
		String monthyear="May 2023";
		String date="15";
		//navigate to applicatio
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n']/descendant::div[@class='css-1dbjc4n r-zso239']//*[name()='svg']//*[local-name()='circle' and @stroke='#DDDDDD']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input[@autocapitalize='sentences']")).sendKeys("chen");
		try {
			
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys("goi");
		} catch (Exception e) {
			
		
		WebElement element=driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//div[@class='r-1862ga2 r-1loqt21 r-1i10wst r-tceitz r-u8s1d css-76zvg2']"));
		element.click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys("goi");
		}
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-rs99b7 r-6koalj r-eqz5dr r-1pi2tsx r-pm9dpa r-1knelpx r-13qz1uu']//div[.='"+monthyear+"']/../following-sibling::div[@class='css-1dbjc4n']/descendant::div[@data-testid='undefined-calendar-day-"+date+"']")).click();
		String returnmonthyear="August 2023";
		int returndate=15;
		for(; ;)
		{
			try {
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-rs99b7 r-6koalj r-eqz5dr r-1pi2tsx r-pm9dpa r-1knelpx r-13qz1uu']//div[@class='css-1dbjc4n r-k8qxaj']//div[.='"+returnmonthyear+"']/../following-sibling::div[@class='css-1dbjc4n']/descendant::div[@data-testid='undefined-calendar-day-"+returndate+"']")).click();
				break;
			} catch (Exception e) {
				System.out.println("catch block");
				
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
			}
		
		}
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti']/descendant::div[@class='css-1dbjc4n']")).click();
		
	}

}
