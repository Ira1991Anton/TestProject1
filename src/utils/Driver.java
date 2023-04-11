package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	//web driver instance
	public static WebDriver driver;
	//created a function
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		
		if(driver==null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		//when driver == null instantiate otherwise 
		return driver;
		
	}
public static void quitDriver() {
	if(driver!=null) {
		driver.quit();
		driver=null;
	}
}
}
