package com.learnautomation.listener;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Extendreport_new {
	@Test
	public void test1()
	{  //Step-1
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/first-extent-report.html");
		//reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Automation report");
		reporter.config().setReportName("Spark_reporter_01");
		//Step-2
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		
		//Step-3
		ExtentTest test1= extent.createTest("Login");
		test1.log(Status.INFO, "User is able to enter email");
		test1.log(Status.INFO, "User is able to enter password");
		test1.log(Status.INFO, "User is able to click on login button");
		test1.log(Status.PASS, "User is able to see the dashboard");
		
		ExtentTest test2=extent.createTest("payment");
		test2.info("User is able to make card details");
		test2.info("User is able to enter CVV details");
		test2.fail("OTP not received", com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath("\\Users\\User\\Desktop\\image.png", "OTP failed").build());
		
		ExtentTest test3=extent.createTest("Logout");
		test3.info("User clicked on logout");
		test3.skip("User is not able to see login page");
		
		extent.flush();
		
	}
	
	
}
