package day5_Xpath_contains_CSS_selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_Xpath_CSS {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
	primetechSearch();
}

public static void primetechSearch() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	//1.Go to http://practice.primetech-apps.com/practice/text-box
	driver.get("http://practice.primetech-apps.com/practice/text-box");
	//2.Find first name, last name, email, password, address fields, and type relevant information.
	//(Create variables for those information and pass the variable to the sendkey() method).
	String firstName =("John");
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
	Thread.sleep(1000);
	
	String lastName=("Smart");
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
	Thread.sleep(1000);
	
	String email = ("JohnSmart@gmail.com");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	Thread.sleep(1000);
	
	String password = ("434ffrfgrg");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[contains(@class, 'btn-enable')]")).click();
	String address = ("2244 MidWest St, Chicago, IL 60508");
	driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(address);
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(1000);
	
  String userFirstName = 
		  driver.findElement(By.xpath("//div[@class='firstName']")).getText();
  System.out.println(userFirstName);
  Thread.sleep(1000);
 
  if(userFirstName.equals(firstName)) {
	  System.out.println("Test, PASS");
  }else {
	  System.out.println("Test, FAIL");
  }
String userLastName = driver.findElement(By.xpath("//div[@class='lastName']")).getText();
System.out.println(userLastName);
if(userLastName.equals(lastName)) {
	System.out.println("Test, PASS");
}else{
	System.out.println("Test, FAIL");
}
String userEmail = driver.findElement(By.xpath("//div[@class='email']")).getText();
System.out.println(userEmail);
if(userEmail.equals(email)) {
	System.out.println("Test, PASS");
}else {
	System.out.println("Test, FAIL");
}
String userPassword = driver.findElement(By.xpath("//div[@class='password']")).getText();
System.out.println(userPassword);
if(userPassword.equals(password)) {
	System.out.println("Test, PASS");
}else {
	System.out.println("Test, FAIL");
}
String userAddress = driver.findElement(By.xpath("//div[@class='address']")).getText();
System.out.println(userAddress);
Thread.sleep(1000);
if(userAddress.equals(address)) {
	System.out.println("Test, PASS");
}else {
	System.out.println("Test, FAIL");
	
}
driver.quit();
}
}
