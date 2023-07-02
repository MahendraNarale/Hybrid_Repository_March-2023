package com.learnautomation.dataprovider;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_from_excel_file {
	
WebDriver driver=null;
	
	@DataProvider(name="Datafromexcel")
	public Object[][] getdata() throws InvalidFormatException, IOException
	{
		System.out.println("Test data generating");
		
		 // load a workbook
  		 XSSFWorkbook wb= new XSSFWorkbook(new File(System.getProperty("user.dir")+"/TestData/Userdata.xlsx"));
  	    // get a specific data from cell
  	     int row= wb.getSheet("User").getPhysicalNumberOfRows(); 
  	     int column =wb.getSheet("User").getRow(0).getPhysicalNumberOfCells();
		Object[][]arr=new Object[row-1][column];
		
		for(int i=1; i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				arr[i-1][j] =wb.getSheet("User").getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		System.out.println("Test data generated");
		return arr;
	
	}	


}
