package training;

import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendarPopUpHandling1 {

	public static void main(String[] args) throws Exception {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//select round trip
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		//enter from city
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("chennai");
		WebElement element=driver.findElement(By.xpath("//p[.='Chennai, India']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		//enter to city
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("vijayawada");
		driver.findElement(By.xpath("//p[.='Vijayawada, India']")).click();
		//enter today date,here i am entering the current date 
		Date date=new Date();//System.out.println(date);
		String d[]=date.toString().split(" ");
		String day=d[0];
		String month=d[1];
		String currentdate=d[2];
		String year=d[5];
		String traveldate=day+" "+month+" "+currentdate+" "+year;
		System.out.println(traveldate);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
		//return date
		String rday="Tue";
		String rmonth="Aug";
		String rdate="15";
		String ryear="2023";
		String returnDate=rday+" "+rmonth+" "+rdate+" "+ryear;
		Thread.sleep(3000);
		for(; ;)
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='"+returnDate+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		//enter number of passengers
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-4']")).click();
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
		driver.findElement(By.xpath("//a[.='Search']")).click();
		driver.close();
		

	}

}
