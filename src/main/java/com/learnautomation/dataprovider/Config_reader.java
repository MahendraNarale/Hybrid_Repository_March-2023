package com.learnautomation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_reader {
	
	public static String getproperty(String key)
	{
		String value=null;
		
		try {
			FileInputStream strm= new FileInputStream(new File(System.getProperty("user.dir")+"/Configuration/config.properties"));
			
			Properties pro= new Properties();
			pro.load(strm);
			
			value=pro.getProperty(key);
			System.out.println(value);
			
		} catch (FileNotFoundException e) {
			System.out.println("file format is not correct"+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Could not read the file"+e.getMessage());
		}
		return value;
	}

}
