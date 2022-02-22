package genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	public String getPropertyFiledata(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(AutoConstant.propertyFilePath);
		p.load(fis);
		p.getProperty(key);
		return p.getProperty(key);
	}

}
