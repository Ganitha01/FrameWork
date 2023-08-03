package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DemoScript1 {
public static void main(String[] args) throws IOException, InterruptedException{
	Random r=new Random();
	int value=r.nextInt(1000);
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties pobj=new Properties();
	pobj.load(fisp);
	String BROWSER=pobj.getProperty("browser");
	String URL=pobj.getProperty("url");
	String USERNAME=pobj.getProperty("username");
	String PASSWORD=pobj.getProperty("password");
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\testdata.xls");
	Workbook wb=WorkbookFactory.create(fise);
	String ORGNAME=wb.getSheet("organization").getRow(1).getCell(2).getStringCellValue()+value;
	wb.close();
	WebDriver driver = null;
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	//Step 1: Launch the Browser - RUNTIME POLYMORPHISM
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(option);
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
		WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser name");
			}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	Thread.sleep(3000);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains(ORGNAME))
	{
		System.out.println(OrgHeader+" ---- PASS ----");
	}
	else
	{
		System.out.println(" ---- Failed ----");
	}
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Sign out successful");
	

	}

}
