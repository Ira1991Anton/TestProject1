package day8_PopUpWindows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW_Practice_2same {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
	}
public static void iframeTest() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	
	
}
	
}
