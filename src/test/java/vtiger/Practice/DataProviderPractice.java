package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.ExccelFileUtility;

public class DataProviderPractice {
	@Test(dataProvider ="getData" )
	public void addToCart(String name,int price,int quantity,String colour,boolean isAvailable)
	{
		System.out.println(name+"-"+price+"-"+quantity+"-"+colour+"-"+isAvailable);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][5];
		data[0][0]="samsung";
		data[0][1]=10000;
		data[0][2]=12;
		data[0][3]="Black";
		data[0][4]=true;
		
		data[1][0]="Iphone";
		data[1][1]=12000;
		data[1][2]=5;
		data[1][3]="white";
		data[1][4]=true;
		return data;
	
//	@Test(dataProvider = "orgwithindustry")
//	public void demo(String sheetname,String industry) throws Exception
//	{
//		System.out.println(sheetname+""+industry);
//
//		
//	}
//	@DataProvider(name="orgwithindustry")
//	public Object[][] getData() throws Exception
//	{ExccelFileUtility eutilExccelFileUtility=new ExccelFileUtility();
//		Object[][] data=eutilExccelFileUtility.readDataFromExcelToDatoProvider("DataProviderOrg");
//		return data;
	}

}















