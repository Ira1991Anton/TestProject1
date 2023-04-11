package day4_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import day3_advancedLocators.EtsyHW;

public class HW_Xpath {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		HW_Xpath search = new HW_Xpath ();
		//search.facebookSearch1();
		//search.facebookSearch2();
	    search.indeedSearch();
		
	}
public void facebookSearch1() {
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Automation");
	driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Automation");
	driver.findElement(By.xpath("//button[@name='login']")).click();
	driver.quit();
}
public void facebookSearch2() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Automation");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@name='websubmit']")).click();
	Thread.sleep(2000);
	driver.quit();
}
public void indeedSearch() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	String searchCriteria = "SDET";
	driver.get("https://www.indeed.com/");
	Thread.sleep(1000);
	String homeURL = driver.getCurrentUrl();
	System.out.println("Home Page URL: " + homeURL);
	String homeTitle = driver.getTitle();
	System.out.println("Home Page Title: " + homeTitle);
	driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys("SDET");
	Thread.sleep(1000);
	WebElement whereField = driver.findElement(By.xpath("//input[@id='text-input-where']"));
	Thread.sleep(1000);
	whereField.sendKeys(Keys.COMMAND + "a");//selects all the text in the box
	Thread.sleep(1000);
	whereField.sendKeys( Keys.DELETE);//deletes all selected content
	Thread.sleep(1000);
	//another way of deleting the text in a box by looping
	//String locationText = whereField.getAttribute("value");
	//for(int i=0; i<locationText.length(); i++) {
		//whereField.sendKeys(Keys.BACK_SPACE);
	//}
	whereField.sendKeys("Washington, DC");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
	Thread.sleep(1000);
	String searchURL = driver.getCurrentUrl();
	System.out.println("Search URL: " + searchURL);
	String searchTitle = driver.getTitle().toUpperCase();
	System.out.println("Search Title: " + searchTitle);
	
	if(!searchURL.equals(homeURL)) {
		System.out.println("Search URL is not equal with home URL Test, PASS");
	}else {
		System.out.println("Test, Fails");
	}
	if(!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {
		System.out.println("Search Title is not equal with Home Title and has search Criteria, PASS");
	}else {
		System.out.println("Test, FAIL");
	}
	String JobsInLocation = driver.findElement(By.xpath("//h1[@class='jobsearch-SerpTitle i-unmask']")).getText();
	System.out.println("Jobs in Location text: " + JobsInLocation);
	
	if(JobsInLocation.contains(searchCriteria)) {
		System.out.println("Jobs in location contains search Criteria Test, PASS");
	}else {
		System.out.println("Test, FAIL");
	}
	String searchCriteriaText = JobsInLocation.substring(0, searchCriteria.length());
    
    System.out.println(searchCriteriaText + " " + searchCriteria.length());
    
	if(searchCriteriaText.equals(searchCriteria)) {
		System.out.println("Jobs in location text equals with Search Criteria, PASS");
	}else {
		System.out.println("Test, FAIL");
	}
}
	

}
