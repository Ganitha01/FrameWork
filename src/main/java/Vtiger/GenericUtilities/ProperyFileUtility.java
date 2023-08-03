package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * 
 * @author ANITHA
 *
 */

public class ProperyFileUtility {
	/**
	 * this method will read the data from property file
	 * @param key
	 * @return
	 * @throws IOException 
	 */

	public String readDataFromPropertyFile(String key) throws IOException
		{FileInputStream fis=new FileInputStream(IContantsUtility.propertyfilepath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		}
	
	}
