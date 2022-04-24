package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public Properties prop;
	
	public ConfigDataProvider(String configdatapath)
	{
		try
		{
			File fs = new File(configdatapath);
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);
		}
		catch(Exception e)
		{
			System.out.println("File not found =" +e);
		}
	}
	public String sreachKey(String key)
	{
		return prop.getProperty(key);
	}
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	public String getPwrd()
	{
		return prop.getProperty("password");
	}
	public String getURL()
	{
		return prop.getProperty("url");
	}

}
