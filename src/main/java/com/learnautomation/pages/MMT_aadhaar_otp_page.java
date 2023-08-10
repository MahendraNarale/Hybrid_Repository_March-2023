package com.learnautomation.pages;

import java.awt.event.ActionEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class MMT_aadhaar_otp_page {
	public WebDriver driver;
	
	//Constructor
	public MMT_aadhaar_otp_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locaters
	private By A_otp=By.id("otpCode");
	private By S_code=By.id("shareCode");
	private By Continue=By.xpath("//button[contains(text(),'Continue')]");
	
	//methods
	public  void enteraadhaarotp(String otp, String sharecode) throws InterruptedException
	{
		driver.findElement(A_otp).sendKeys(otp);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();
		driver.findElement(S_code).sendKeys(sharecode);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

	}
}


