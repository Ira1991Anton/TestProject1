package day6_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_WebElements {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		CheckBox();
		RadioButton();
		Buttons();
		Links();
	}
public static void CheckBox() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://practice.primetech-apps.com/practice/web-tables");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Elements']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@id='check-box']")).click();
	Thread.sleep(1000);
	
	WebElement javaElement = driver.findElement(By.xpath("//input[@id='Java']"));
	WebElement javaScriptElement = driver.findElement(By.xpath("//input[@id='JavaScript']"));
	WebElement cElement = driver.findElement(By.xpath("//label[text()='C#']"));
	WebElement pythonElement = driver.findElement(By.xpath("//label[text()='Python']"));
	
}
public static void RadioButton() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://practice.primetech-apps.com/practice/web-tables");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Elements']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@id='radio-button']")).click();
	Thread.sleep(1000);
	
    WebElement usaElement =	driver.findElement(By.xpath("//label[text()='USA']"));
	WebElement canadaElement = driver.findElement(By.xpath("//label[text()='Canada']"));
	WebElement englandElement = driver.findElement(By.xpath("//label[text()='England']"));
	WebElement  japanElement = driver.findElement(By.xpath("//label[text()='Japan']"));
}
public static void Buttons() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
	
	driver.get("http://practice.primetech-apps.com/practice/web-tables");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Elements']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@id='buttons']")).click();
	Thread.sleep(1000);
	
	WebElement buttonElement = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
	WebElement rightBtnElement = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
	WebElement clickBtnElement  = driver.findElement(By.xpath("//button[text()='Click Me']"));
	
	
}
public static void Links() throws InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   
	  
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Elements']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='links']")).click();
		Thread.sleep(1000);
		
		WebElement amazonElement = driver.findElement(By.xpath("//a[@id='amazon']"));
		WebElement facebookElement = driver.findElement(By.xpath("//a[@id='facebook']"));
	
		driver.quit();
}

}
