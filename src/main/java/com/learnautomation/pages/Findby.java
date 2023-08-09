package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.learnautomation.helper.Utility;

public class Findby {

public WebDriver driver;
	
	public Findby(WebDriver driver)
	{
		this.driver=driver;
		
	}
	@FindBy(id="email1") WebElement email1;
	@FindBy(id="password1") WebElement password1;
	@FindBy(id="submitbtn") WebElement submitbtn;
	@FindBy(id="errormessage1") WebElement errormessage1;
	
	
	public void logintoapplication(String email, String password) 
	{
		email1.sendKeys(email);
		password1.sendKeys(password);
		submitbtn.click();
		
	}
	
	public String errormessage()
	{
		String str=errormessage1.getText();
		System.out.println(str);
		return str;
	}

}

	

