package training;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MakeMyTripBus {

	public static void main(String[] args) throws Exception {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		//navigate to applicatio
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//select buses
		driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chBuses']")).click();
		//enter from city
		driver.findElement(By.xpath("//span[@data-cy='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("chennai");
		driver.findElement(By.xpath("//span[.='Chennai, Tamil Nadu']")).click();
	
		//enter to city
		//driver.findElement(By.xpath("//span[@data-cy='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("vijayawada");
		driver.findElement(By.xpath("//span[text()='Vijayawada, Andhra Pradesh']")).click();
		//select travel date
		//driver.findElement(By.id("travelDate")).click();
	Date date=new Date();
	String d[]=date.toString().split(" ");
	String day=d[0];
	String month=d[1];
	String cdate=d[2];
	String year=d[5];
	String travelDate=day+" "+month+" "+cdate+" "+year;
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
		driver.findElement(By.id("search_button")).click();
		List<WebElement> busnames=driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']"));
		List<WebElement> prices=driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']/ancestor::div[@class='makeFlex']/descendant::span[@id='price']"));
		//print the bus name and price datails & print least price and bus name
		int min=Integer.MAX_VALUE;
		String name="";
		for(int i=0;i<busnames.size();i++)
		{
			System.out.println(busnames.get(i).getText()+"--->"+prices.get(i).getText());
			String p=prices.get(i).getText().replaceAll("[^0-9]","");
			int busprice=Integer.parseInt(p);
			String bname=busnames.get(i).getText();
			if(min>busprice)
			{
				min=busprice;
				name=bname;
			}
			
		}
		System.out.println(name+"--->"+min);
		driver.close();
	}

}
