package day4_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Contains_Text {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
	//etsyXpath();
	etsyCssSelector();
}
public static void etsyXpath() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	
	// Go to etsy.com
			driver.get("https://etsy.com");
			// Click on Sign in.
			driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
			Thread.sleep(1000);
			// Click on Register.
			driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
			Thread.sleep(1000);
			// Enter an email address, (jon.dow@gmail.com)
			driver.findElement(By.xpath("//input[contains(@id, 'email_field')]")).sendKeys("jon.dow@gmail.com");
			// Enter first name.
			driver.findElement(By.xpath("//input[contains(@id, 'first_name_field')]")).sendKeys("jon");
			// Enter password.
			driver.findElement(By.xpath("//input[contains(@id, 'password_field')]")).sendKeys("jondowthe2nd");
			// Click on Register.
			driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
			Thread.sleep(2000);
			// Verify you get the error message:
			// “Sorry, the email you have entered is already in use.”
			String errorMessage = 
					driver.findElement(By.xpath("//div[contains(text(), 'already in use.')]")).getText();
			if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
				System.out.println("Test Pass!");
			} else {
				System.out.println("Test Fail!");
			}
	
	
}
public static void etsyCssSelector() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	
	driver.get("https:etsy.com");
	// Click on Sign in.
			driver.findElement(By.cssSelector(".select-signin")).click();
			Thread.sleep(1000);
			// Click on Register.
			driver.findElement(By.cssSelector(".select-register")).click();
			Thread.sleep(1000);
			// Enter an email address, (jon.dow@gmail.com)
			driver.findElement(By.cssSelector("input[name=email]")).sendKeys("jon.dow@gmail.com");
			// Enter first name.
			driver.findElement(By.cssSelector("input[name=first_name]")).sendKeys("jon");
			// Enter password.
			driver.findElement(By.cssSelector("input[name=password]")).sendKeys("jondowthe");
			Thread.sleep(500);
			// Click on Register.
			driver.findElement(By.cssSelector("button[value=register]")).click();
			Thread.sleep(2000);
			// Verify you get the error message:
			// “Sorry, the email you have entered is already in use.”
			String errorMessage = 
					driver.findElement(By.cssSelector("div[id=aria-join_neu_email_field-error]")).getText();
			System.out.println(errorMessage);
			if (errorMessage.equals("Sorry, the email you have entered is already in use.")) {
				System.out.println("Test Pass!");
			} else {
				System.out.println("Test Fail!");
			}
		}
}
	

