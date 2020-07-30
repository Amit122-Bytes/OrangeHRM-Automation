package com.orangehrm.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig()
	{
		File src=new File("./Configuration/configuration.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getusername()
	{
		String uname=pro.getProperty("Username");
		return uname;
	}
	public String getpassword()
	{
		String pass=pro.getProperty("Password");
		return pass;
	}
	public String chrome()
	{
		String pass=pro.getProperty("chromedriver");
		return pass;
	}
	public String firefox()
	{
		String pass=pro.getProperty("firefox");
		return pass;
	}
	public String IDE()
	{
		String pass=pro.getProperty("ide");
		return pass;
	}

}
