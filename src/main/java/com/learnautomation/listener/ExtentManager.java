package com.learnautomation.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learnautomation.helper.Utility;

public class ExtentManager {
	
	public static ExtentReports extent;

	public static ExtentReports getInstance() {
    	if (extent==null)
    	{
    		extent=createInstance();
    		 return extent;
    	}
    	else
    	{
    		 return extent;
    	}
    	
    } 
    
	
	public static ExtentReports createInstance()
	{
		
		ExtentSparkReporter sparkreporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Automation"+ Utility.getdatetime()+".html");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setDocumentTitle("Automation report");
		sparkreporter.config().setReportName("Extend report");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		return extent;
		
	}

}
