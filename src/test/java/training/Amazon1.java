package training;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon1 {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(option);
	driver.navigate().to("https://www.amazon.in/l/29657746031?pf_rd_r=S5T04TC13VSAMY0MB8W4&pf_rd_p=25fed911-cde5-499e-b46d-974cfe1eef60&pd_rd_r=13172aac-9c1f-40d2-b5d0-26472daadbbf&pd_rd_w=ieUJB&pd_rd_wg=MrwWW&ref_=pd_gw_unk");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement element=driver.findElement(By.id("twotabsearchtextbox"));
	element.sendKeys("fire tv stick");
	element.submit();
	List<WebElement> pname=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	for(WebElement E:pname)
	{
	String name=E.getText();
	WebElement element1=driver.findElement(By.xpath("//span[text()='"+name+"']/../../../..//span[@class='a-price-whole']"));
	System.out.println(name+"-"+element1.getText());
	}
	driver.quit();
	//("//span[.='Fire TV Stick with Alexa Voice Remote (includes TV and app controls) | HD streaming device']/../../../..//div[@class='a-row a-spacing-micro']/../..//span[@class='a-price-whole']"));
	}

}
