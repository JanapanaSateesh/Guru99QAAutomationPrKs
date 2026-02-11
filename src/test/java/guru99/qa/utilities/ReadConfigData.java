package guru99.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {
	Properties proobj;

	public ReadConfigData() throws IOException {
		File file=new File("./Configuration/config.properties");
		FileInputStream fi=new FileInputStream(file);
		proobj=new Properties();
		proobj.load(fi);
	}
	
	public String getPropertyValue(String propertKeyName) {
		return proobj.getProperty(propertKeyName);
		 
	}
}
