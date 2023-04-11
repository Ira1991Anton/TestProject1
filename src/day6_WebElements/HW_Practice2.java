package day6_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_Practice2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		amazonHomework();
	}

public static void amazonHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 //go to amazon.com    
		driver.get("https://amazon.com");
		 //click on signin 
		driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]")).click();
	     //verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page.");
		}else {
			System.out.println("I am not on the sign in page.");
		}
	     //navigate back, and navigate forward
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
	     //verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page on the second time.");
		}else {
			System.out.println("I am not on the sign in page on the second time.");
		}
	     //click on create new account, verify you are on new account create page.
		driver.findElement(By.id("createAccountSubmit")).click();
		WebElement createAccountText = 
				driver.findElement(By.xpath("//h1[contains(text(), \"Create account\")]"));
		if (createAccountText.isDisplayed()) {
			System.out.println("I am on the account creation page.");
		}else {
			System.out.println("I am not on the account creation page.");
		}
	     //navigate back, verify you are on the sign-in page.
		driver.navigate().back();
		Thread.sleep(1000);
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page on the third time.");
		}else {
			System.out.println("I am not on the sign in page on the third time.");
		}
	     //navigate forward, verify you are on the create account page.
		driver.navigate().forward();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h1[contains(text(), \"Create account\")]")).isDisplayed()) {
			System.out.println("I am on the account creation page second time.");
		}else {
			System.out.println("I am not on the account creation page second time.");
		}
	     //click on the Continue button without filling the form
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
	     //verify error messages displayed and get text to verify:
	      //Enter your name
		WebElement nameErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		if (nameErrorMessage.isDisplayed()) {
			if (nameErrorMessage.getText().equals("Enter your name")) {
				System.out.println("Name error message displays and it matches.");
			}else {
				System.out.println("Name error message does not display or it doesn't match.");
			}
		}
	      //Enter your email or mobile phone number
		WebElement emailErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
		if (emailErrorMessage.isDisplayed()) {
			if (emailErrorMessage.getText().equals("Enter your email or mobile phone number")) {
				System.out.println("Email error message displays and it matches.");
			}else {
				System.out.println("Email error message does not display or it doesn't match.");
			}
		}
	     //Minimum 6 characters required
		WebElement passwordErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
		if (passwordErrorMessage.isDisplayed()) {
			if (passwordErrorMessage.getText().equals("Minimum 6 characters required")) {
				System.out.println("Password error message displays and it matches.");
			}else {
				System.out.println("Password error message does not display or it doesn't match.");
			}
		}
	}
	
}

