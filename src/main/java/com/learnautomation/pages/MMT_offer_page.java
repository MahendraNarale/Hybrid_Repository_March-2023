package com.learnautomation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMT_offer_page {

public WebDriver driver;
	
	//Constructor
	public MMT_offer_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locaters
	private By offerotp=By.xpath("//input[@placeholder='Enter OTP']");
	private By accept=By.xpath("//span[contains(text(),'ACCEPT')]");
	
	//methods
	public  void offerpage(String Enterotp)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(offerotp)).sendKeys(Enterotp);	
		wait.until(ExpectedConditions.elementToBeClickable(accept)).click();;
	}
}
	



