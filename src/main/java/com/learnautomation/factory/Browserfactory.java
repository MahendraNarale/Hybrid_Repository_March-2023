package com.learnautomation.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.learnautomation.dataprovider.Config_reader;

public class Browserfactory {
	static WebDriver driver;
	
	//getter setter method to return driver whenever needed. 
	public static WebDriver getdriver()
	{
		return driver;
	}
	
	// Method to launch browser and url
			public static WebDriver startbrowser(String browsername, String applicationurl)
			{
				
				if(browsername.equalsIgnoreCase("chrome")||browsername.equalsIgnoreCase("Google chrome"))	
				{    
					ChromeOptions opt= new ChromeOptions();
					if((Config_reader.getproperty("headless").contains("true")))
							{
						        opt.addArguments("--headless=new");
							}
					driver=new ChromeDriver(opt);
				
				}
				else if(browsername.equalsIgnoreCase("Edge")||browsername.equalsIgnoreCase("microsoft Edge"))
				{
					EdgeOptions opt= new EdgeOptions();
					if((Config_reader.getproperty("headless").contains("true")))
							{
						        opt.addArguments("--headless=new");
							}
					driver=new EdgeDriver(opt);
				}
				else if(browsername.equalsIgnoreCase("firefox")||browsername.equalsIgnoreCase("firefox browser"))
				{
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("We don't support "+ browsername);
				}
				 
				driver.manage().window().maximize();
				
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(Config_reader.getproperty("pageloadtime"))));
				driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Integer.parseInt(Config_reader.getproperty("scripttimeout"))));
				
				driver.get(applicationurl);
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config_reader.getproperty("implicitwait"))));
				
				return driver;

				
			}
		

}
