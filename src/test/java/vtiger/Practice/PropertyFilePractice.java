package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
public static void main(String[] args) throws IOException {
	//Step-1 load the file in java readable format using file input stream
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	//step-2 create an object of properties from java.util
	Properties pObj=new Properties();
	//Step-3 load file input stream into properties
	pObj.load(fis);
	//step-4 using the keys and read the values
	String BROWSER=pObj.getProperty("browser");
	//System.out.println(pObj.getProperty("browser"));
	System.out.println(BROWSER);
	
	
	

	}

}
