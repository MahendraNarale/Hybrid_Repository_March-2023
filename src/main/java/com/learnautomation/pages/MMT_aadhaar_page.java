package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMT_aadhaar_page {
	
public WebDriver driver;
	
	//Constructor
	public MMT_aadhaar_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locaters
	private By A_No=By.id("aadhaarNo");
	private By SCode=By.id("securityCode");
	private By AgreeContinue=By.xpath("//button[contains(text(),'Agree & Continue')]");
	
	//methods
	public  void enteraadhaar(String AadhaarNo, String SecurityCode)
	{
		driver.findElement(A_No).sendKeys(AadhaarNo);
		driver.findElement(SCode).sendKeys(SecurityCode);
		driver.findElement(AgreeContinue).click();
	}
}


