package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		etsySearch();
	}
	public static void etsySearch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//Go to etsy.com
		driver.get("https://www.etsy.com/");
	    Thread.sleep(1000);
	  //Click on Sign in.
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
		Thread.sleep(1000);
		//Click on Register.
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")).click();
		Thread.sleep(1000);
		//Enter an email address, (jon.dow@gmail.com)
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jon.dow@gmail.com");
		Thread.sleep(1000);
		//Enter first name.
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Jon");
		//Enter password.
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("kkiodsg67ju");
		Thread.sleep(500);
		//Click on Register.
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
		Thread.sleep(1000);
		//Verify you get the error message:
		//“Sorry, the email you have entered is already in use.”
		String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
		String actualErrorMessage=
		driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
	     
		if(actualErrorMessage.equals(expectedErrorMessage)) {
			System.out.println("Test, PASS");
		}else {
			System.out.println("Test, FAIL");
		}
		
	 driver.quit();
		
	}
	

}
