package org.automation.testingworld.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

	public static String fetchPropertyValue(String key)
	{
		String value = "";
		try
		{
		FileInputStream f = new FileInputStream("./Config/Config.properties");
		Properties prop = new Properties();
		prop.load(f);
		value = prop.get(key).toString();
		}
		catch(Exception e)
		{
			
		}
		return value;
	}
	public static String fetchElementValue(String key)
	{
		String value = "";
		try
		{
		FileInputStream f = new FileInputStream("./Config/Elements.properties");
		Properties prop = new Properties();
		prop.load(f);
		value = prop.get(key).toString();
		}
		catch(Exception e)
		{
			
		}
		return value;
	}
}
