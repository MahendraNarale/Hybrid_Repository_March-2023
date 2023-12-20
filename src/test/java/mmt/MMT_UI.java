package mmt;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.dataprovider.Config_reader;
import com.learnautomation.helper.Baseclass;
import com.learnautomation.pages.MMT_UI_Homepage;
import com.learnautomation.pages.MMT_aadhaar_otp_page;
import com.learnautomation.pages.MMT_aadhaar_page;
import com.learnautomation.pages.MMT_offer_page;
import com.learnautomation.pages.MMT_pan_dob_page;

public class MMT_UI extends Baseclass{
	@Test(priority = 0)
	public void test_home_page()
	{
		MMT_UI_Homepage page1=new MMT_UI_Homepage(driver);
		page1.homepage();
		
	}
	
	@Test(priority = 1)
	public void test_pan_dob_page()
	{
		MMT_pan_dob_page page2=new MMT_pan_dob_page(driver);
		page2.enterpandob(Config_reader.getproperty("PAN"), Config_reader.getproperty("DOB"));
		
	}

	@Test(priority = 2)
	public void test_aadhaar_page()
	{
		MMT_aadhaar_page page3=new MMT_aadhaar_page(driver);
		page3.enteraadhaar(Config_reader.getproperty("AadhaarNo"), Config_reader.getproperty("SecurityCode"));
		
	}
	
	@Test(priority = 3)
	public void test_aadhaar_otp_page() throws InterruptedException
	{
		MMT_aadhaar_otp_page page4=new MMT_aadhaar_otp_page(driver);
		page4.enteraadhaarotp(Config_reader.getproperty("otp"), Config_reader.getproperty("sharecode"));
		
	}
	
	@Test(priority = 4)
	public void test_mmt_offer_page()
	{
		MMT_offer_page page5=new MMT_offer_page(driver);
		page5.offerpage(Config_reader.getproperty("Enterotp"));
		//String url=driver.getCurrentUrl();
		//System.out.println("Current page url is " +url);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean state=wait.until(ExpectedConditions.urlContains("https://www.makemytrip.com"));
		Assert.assertTrue(state);
		
		
	}

}
