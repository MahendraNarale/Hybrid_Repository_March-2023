package com.learnautomation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.dataprovider.Config_reader;
import com.learnautomation.dataprovider.Data_from_excel_file;
import com.learnautomation.dataprovider.Excelreader;
import com.learnautomation.factory.Browserfactory;
import com.learnautomation.helper.Baseclass;
import com.learnautomation.helper.Utility;
import com.learnautomation.pages.Loginpage;


public class Logintest extends Baseclass
{
   /*
	@Test(dataProvider = "Datafromexcel", dataProviderClass = Data_from_excel_file.class)
	public void testclass(String uname, String pass) 
	{
	    
		Loginpage page= new Loginpage(driver);
		page.logintoapplication(uname, pass);
		String str=page.errormessage();
		Assert.assertTrue(page.errormessage().contains(str), "Something went wrong");	
	
	}
	
	*/
	
	@Test(dataProvider = "Datafromexcel", dataProviderClass = Data_from_excel_file.class)
	public void creatuser(String Name, String Email, String Password, String Interest, String Gender, String State, String Hobbies) 
	{
		Actions act = new Actions(driver);
		Utility.Elementwaitandhighlight(driver, By.id("name")).sendKeys(Name);
		Utility.Elementwaitandhighlight(driver,By.id("email")).sendKeys(Email);
		Utility.Elementwaitandhighlight(driver,By.id("password")).sendKeys(Password);
		Utility.Elementwaitandhighlight(driver,By.xpath("//label[text()='"+Interest+"']")).click();
		act.scrollByAmount(20, 300).perform();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='genders-div']//input[@value='"+Gender+"']"))).click();
		Utility.Elementwaitandhighlight(driver,By.id("state")).sendKeys(State);
		Utility.Elementwaitandhighlight(driver,By.xpath("//select[@id='hobbies']//option[@value='"+Hobbies+"']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='submit-btn']")).getText().contains("Sign up"), "User is not created");
		Utility.Elementwaitandhighlight(driver,By.xpath("//button[@class='submit-btn']")).click();
		
	}
	
}
