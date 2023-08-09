package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.learnautomation.helper.Utility;

public class Loginpage {
	
	public WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By Username= By.id("email1");
	private By Password= By.id("password1");
	private By Loginbutton= By.className("submit-btn");
	private By errormessage1= By.className("errorMessage");
	
	public void logintoapplication(String email, String password) 
	{
		Utility.Elementwaitandhighlight(driver, Username).sendKeys(email);
		Utility.Elementwaitandhighlight(driver, Password).sendKeys(password);
		Utility.Elementwaitandhighlight(driver, Loginbutton).click();
		
	}
	
	public String errormessage()
	{
		String str=Utility.Elementwaitandhighlight(driver, errormessage1).getText();
		System.out.println(str);
		return str;
	}

}
