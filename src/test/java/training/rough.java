package training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class rough {

	public static void main(String[] args) throws Exception {
	
		Date date=new Date();
		System.out.println(date);
		String d[]=date.toString().split(" ");
		String day=d[0];
		String month=d[1];
		String cdate=d[2];
		String year=d[5];
		String travelDate=day+" "+month+" "+cdate+" "+year;
		System.out.println(travelDate);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		System.out.println(driver.getTitle());
		
//		FileInputStream fis=new FileInputStream(".//src/test/resources/TestData.xlsx");
//		Workbook wb=WorkbookFactory.create(fis);
//		Sheet sh=wb.getSheet("Sheet1");
//		int row=sh.getLastRowNum();
//		
//		System.out.println(row);
	}

}
