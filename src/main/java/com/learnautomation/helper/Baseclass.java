package com.learnautomation.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v110.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.learnautomation.dataprovider.Config_reader;
import com.learnautomation.factory.Browserfactory;

import net.bytebuddy.asm.Advice.Return;

public  class Baseclass
{  
  	public WebDriver driver;
  	

	@BeforeMethod
	public void setupbrowser()
	{ 
		System.out.println("Log:info-Before method");
		System.out.println("Log:info-browser getting started");
	    driver=Browserfactory.startbrowser(Config_reader.getproperty("Browsername"), Config_reader.getproperty("New_use_url"));
		System.out.println("Log:info-browser started");
		
	}
	
	@AfterMethod
	public void Closebrowser()
	{
		System.out.println("Log:info-After method");
		driver.quit();
		System.out.println("Log:info-test is done");
	}
	
	

	
}
