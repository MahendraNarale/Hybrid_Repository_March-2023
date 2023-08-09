package selenium_grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v110.browser.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid {
	
	public static void main(String[] args) throws InterruptedException {
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName(org.openqa.selenium.remote.Browser.CHROME.browserName());
		
		try {
			URL gridurl = new URL("http://localhost:4444/wd/hub");
			WebDriver driver=new RemoteWebDriver(gridurl, cap);
			driver.get("https://freelance-learn-automation.vercel.app/login");
			driver.manage().window().maximize();
			Thread.sleep(20);
			System.out.println("Title of this page is "+driver.getTitle());
			driver.quit();
		} catch (MalformedURLException e) {
			
			System.out.println("Not able to connect to grid"+e.getMessage());
			
		}
		
		
		

	}

}
