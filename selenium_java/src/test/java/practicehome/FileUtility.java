package practicehome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/externaldata/data.properties");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	public static void main(String[] args) throws Throwable {
		
		FileUtility fu=new FileUtility();
		String browser = fu.getDataFromPropertiesFile("browser");
		System.out.println(browser);
		
		
	}

}
