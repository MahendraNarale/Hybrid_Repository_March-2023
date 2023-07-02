package com.learnautomation.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Writable;
import com.learnautomation.factory.Browserfactory;
import com.learnautomation.helper.Utility;

public class Listener_Itest implements ITestListener

{
	ExtentReports extent= ExtentManager.getInstance();
	  
	ThreadLocal<ExtentTest> parenttest=new ThreadLocal<ExtentTest>();
	
	  public synchronized void onTestStart(ITestResult result)
	  {
		ExtentTest extentTest =extent.createTest(result.getMethod().getMethodName());
		parenttest.set(extentTest);
		   System.out.println("Log:info - Test started!!!"+ result.getMethod().getMethodName()); 
	  }

	  public synchronized void onFinish(ITestContext context) 
	  {
		    extent.flush();
		    System.out.println("Log:info- Test End"+context.getName());
	  }
	  
	  public synchronized void onTestSuccess(ITestResult result) 
	  {
		   parenttest.get().pass("Test passed");
		    System.out.println("Log:Pass-Test passed"+result.getMethod().getMethodName());
	  }
	  
	  public synchronized void onTestFailure(ITestResult result) 
	  {    String screenshot= Utility.capturescreenshotasBase64(Browserfactory.getdriver());
		   parenttest.get().fail("Test failed", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot, "Screenshot of failed test").build());
		   System.out.println("Log:fail- Test Failure"+result.getMethod().getMethodName());
		   System.out.println("LOg:fail-Test failure"+result.getThrowable().getMessage());
	  }
	  
		public synchronized void onTestSkipped(ITestResult result) 
		{
               parenttest.get().skip("Test Skipped");
			   System.out.println("Log:skip- Test skipped"+result.getMethod().getMethodName());
			   System.out.println("LOg:skip-Test skipped"+result.getThrowable().getMessage());
		}
}
