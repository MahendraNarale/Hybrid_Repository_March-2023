package com.learnautomation.dataprovider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excelreader {
	static XSSFWorkbook wb;
	
	@DataProvider(name="Getdatafromexcelsheet")
	public static Object[][] getdatafromexcel(String User)
	{
		
		System.out.println("Test data generating");
		
		 // load a workbook
		 
		try {
			wb = new XSSFWorkbook(new File(System.getProperty("User.dir")+"/Testdata/Userdata.xlsx"));
		} catch (InvalidFormatException e) {
			System.out.println("file format is invalid"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("use valid file"+e.getMessage());
		}
	    // get a specific data from cell
	     int row= wb.getSheet(User).getPhysicalNumberOfRows(); 
	     int column =wb.getSheet(User).getRow(0).getPhysicalNumberOfCells();
		Object[][]arr=new Object[row-1][column];
		
		for(int i=1; i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				arr[i-1][j] =celltype(User,i,j);
				
			}	
	     }
		return arr;
	
	}
	
	// This method will identify the cell type and call the respective method
	
	public static String celltype(String User, int row, int column)
	{
		XSSFCell cell=wb.getSheet(User).getRow(row).getCell(column);
		String Data="";
		
		if(cell.getCellType()==CellType.STRING)
		{
			
			Data=cell.getStringCellValue();
			
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
		double	value=cell.getNumericCellValue();
		  Data =String.valueOf(value);
		}
		else if(cell.getCellType()==CellType.BOOLEAN)
		{
			boolean bol=cell.getBooleanCellValue();
			Data=String.valueOf(bol);
		}
		return Data;
	}	
	
}
