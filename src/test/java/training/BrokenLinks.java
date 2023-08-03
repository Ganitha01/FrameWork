package training;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.amazon.in/ref=nav-log");//http://the-internet.herokuapp.com/broken_images
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> allLinks=driver.findElements(By.xpath("//a"));//By.tagName("img");
		List<String> brokenLinks=new ArrayList<String>();
		for(int i=0;i<allLinks.size();i++)
		{
			String links=allLinks.get(i).getAttribute("href");//src
			int statusCode=0;
			try {
				URL url=new URL(links);
				URLConnection urlConnect=url.openConnection();
				HttpURLConnection httpURLconnection=(HttpURLConnection)urlConnect;
				statusCode=httpURLconnection.getResponseCode();
				if(statusCode>=400)
				{
					brokenLinks.add(links+" "+statusCode);
				}
				
			} catch (Exception e) {
				brokenLinks.add(links+" "+statusCode);
				continue;
			}
		}
		for(String s:brokenLinks)
		{
			System.out.println(s);
		}
		
		

	}

}
