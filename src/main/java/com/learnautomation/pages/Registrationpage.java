package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class Registrationpage {
	public WebDriver driver;
	public Registrationpage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	private By Name=By.id("name");
	private By email=By.id("email");
	private By password=By.id("password");
	//private By Interest=By.xpath("//label[text()='"+Interest+"']");
	
	public void registeruser(String Username, String Email, String Password)
	{
		
	   driver.findElement(Name).sendKeys(Username);
	   driver.findElement(email).sendKeys(Email);
	   driver.findElement(password).sendKeys(Password);
	   
	   
	}
	
	
	
	
	
	
	
	
	

}
