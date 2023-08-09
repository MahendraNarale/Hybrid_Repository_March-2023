package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMT_UI_Homepage {
	
	public WebDriver driver;
	
	//Constructor
	public MMT_UI_Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locaters
	private By Proceed_button=By.id("proceed-button");
	
	//methods
	public void homepage()
	{
		driver.findElement(Proceed_button).click();
	}
	

} 
