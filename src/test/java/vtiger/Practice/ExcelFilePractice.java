package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {
public static void main(String[] args) throws Exception, IOException {
	//step-1 load the file in java readable format
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xls");
	//step-2 create a workbook
	Workbook wb=WorkbookFactory.create(fis);
	//step-3 get inside the sheet
	Sheet sh=wb.getSheet("oranization");
	//step-4 get the used row
	Row rw=sh.getRow(1);
	//step-5 create a cell
	Cell ce=rw.createCell(7);
	//step-6 write data into cell
	ce.setCellValue("anitha");
	//step-7 open the file in java write format and write into work book
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testdata.xls");
	wb.write(fos);
	System.out.println("data added");
	wb.close();
	
	
	

	}

}
