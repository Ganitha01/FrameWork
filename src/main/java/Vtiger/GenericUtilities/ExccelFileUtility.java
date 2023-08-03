package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * This class consists of generic methods related to Excel sheet
 * @author ANITHA
 *
 */
public class ExccelFileUtility {
	/**
	 * This method will read data from excelSheet
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetname,int rowNo,int celNo ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IContantsUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		String value =wb.getSheet(sheetname).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	/**
	 * This method will write data into excel
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public void writeIntoExcel(String sheetname,int rowNo,int celNo,String value ) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IContantsUtility.excelfilepath);
	Workbook wb=WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetname);//or here we can create a sheet also
	Row rw = sh.createRow(rowNo);
	Cell cel = rw.createCell(celNo);
	cel.setCellValue(value);
	FileOutputStream fos=new FileOutputStream(IContantsUtility.excelfilepath);
	wb.write(fos);
	wb.close();
	}
/**
 * this methode will read the data from excel sheet and return it to data provider
 * @param sheetName
 * @return
 * @throws Exception
 */
public Object[][] readDataFromExcelToDatoProvider(String sheetName) throws Exception
{
	FileInputStream fis=new FileInputStream(IContantsUtility.excelfilepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int lastRow=sh.getLastRowNum();
	int lastcell=sh.getRow(0).getLastCellNum();
	Object[][] data=new Object[lastRow][lastcell];
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}
}












