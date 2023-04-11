package day9_ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		actionsDemo() ;
	}
public static void actionsDemo() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	Actions letsdo = new Actions(driver);//driver is and WebDriver instance
	
	//go to Etsy.com
			driver.get("https://etsy.com");
			//Hover Over on Jewelry & Accessories
			WebElement jeverlyTab = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
			letsdo.moveToElement(jeverlyTab).build().perform();
			
			//Mouseover on Bags & Purses
			WebElement bagPurses = driver.findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));
			letsdo.moveToElement(bagPurses).build().perform();
			Thread.sleep(1000);
			
			//Mouseover to Shoulder Bags
			WebElement shoulderBags = 
					driver.findElement(By.xpath("//a[contains(text(), 'Shoulder Bags')]"));
			letsdo.moveToElement(shoulderBags).build().perform();
			//Click on the shoulder bags
			shoulderBags.click();
			//Verify you are on the Shoulder bags page
			if (driver.findElement(By.xpath("//h1[text()='Shoulder Bags']")).isDisplayed()) {
				System.out.println("We are on the Bag page.");
			}else {
				System.out.println("We are NOT on the Bag page.");
			}
			
}
}
