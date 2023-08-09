package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMT_pan_dob_page {
	
	public WebDriver driver;
	
	//Constructor
	public MMT_pan_dob_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locaters
	private By pan=By.id("pan");
	private By dob=By.id("dob");
	private By save_continute=By.xpath("//span[contains(text(),'SAVE & CONTINUE')]");
	
	//methods
	public  void enterpandob(String PAN, String DOB)
	{
		driver.findElement(pan).sendKeys(PAN);
		driver.findElement(dob).sendKeys(DOB);
		driver.findElement(save_continute).click();
	}
}
