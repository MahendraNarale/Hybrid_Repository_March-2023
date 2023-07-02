package com.learnautomation.helper;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.dataprovider.Config_reader;

public class Utility {
	
	public static WebElement Elementwaitandhighlight(WebDriver driver, By locater) 
	{
	
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locater));
	    if(Config_reader.getproperty("highlightElement").contains("true"))
	    {
	    	return highliter(driver, locater);
	    }
	    else
	    {
	    	return ele;
	    }
		
	}
	
	// Method-1: We can use this method by class name as it is static
	public static void selectedvalues(WebDriver driver, String locater, String elementtosearch)
	
	{
		List<WebElement> list=driver.findElements(By.xpath(locater));
		
		for( WebElement ele: list)
		{
		String name=ele.getText();
			
			if(name.contains(elementtosearch))
			{
			
				ele.click();
				System.out.println("Java page is opened using method-1");
				break;
			}
		}
		driver.quit();
		
	}
	
	// Method-2: Above method is overload by changing the method signature
	public static void selectedvalues(WebDriver driver, By locater, String elementtosearch)
	
	{
		List<WebElement> list=driver.findElements(locater);
		
		for( WebElement ele: list)
		{
		String name=ele.getText();
			
			if(name.contains(elementtosearch))
			{
			
				ele.click();
				System.out.println("Java page is opened using method-2");
				break;
			}
		}
		//driver.quit();
		
	}
	
	
	
	/*This method will capture screenshots
	 * used string concatenation concept
	 */
	public static void capturescreenshot(WebDriver driver)
	{
		
	   
		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("./Screenshots/screenshot"+getdatetime()+".png"));
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	// This method will capture screenshots as Base64 image
	public static String capturescreenshotasBase64 (WebDriver driver)
	{
		
	   TakesScreenshot ts= (TakesScreenshot) driver;
	   String screenshot=ts.getScreenshotAs(OutputType.BASE64);
	   return screenshot;
	   
	
	}

	
	// This method will return time and date in given format
  public static String getdatetime()
  {
	  
	    Date d= new Date();
	     System.out.println(d);
	     
		SimpleDateFormat newformat= new SimpleDateFormat("HH_mm_ss_yyyy_MM_dd");
		String currentformat=newformat.format(d);
		System.out.println(currentformat);
		
	return currentformat;
	  
  }
	
  // This method will capture the screenshot of Webelement
  
  public static void capturescreenshotofwebelement(WebElement ele)
  {
	  
		File src=ele.getScreenshotAs(OutputType.FILE);
		
		File dest= new File("./screenshots/Webelement_"+Utility.getdatetime()+".png");
		
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			
			System.out.println("Screenshot not allowed");
		}
		
  }
  
  // This method can be used to highlite element and unhighlite

  public static WebElement highliter(WebDriver driver, By locater) 
  {
	  JavascriptExecutor js= (JavascriptExecutor) driver;
		//Highlite element and sendkey
		WebElement ele=driver.findElement(locater);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red; background: yellow')", ele);
		
		//Unhighlite element
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')", ele);
	  
	return ele;
	  
  }
}
