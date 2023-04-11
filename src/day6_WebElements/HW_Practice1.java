package day6_WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_Practice1 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		//RadioButton();
		checkboxHomework();
	}
public static void RadioButton() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	// go to http://practice.primetech-apps.com/practice/radio-button
	driver.get("http://practice.primetech-apps.com/practice/radio-button");
   //Find those available radio buttons.
	List<WebElement>radioButtons = driver.findElements(By.cssSelector(".form-check-input"));
	//Check if it's displayed and enabled,  
	//using for each loop to check it
	for(WebElement singleRadio : radioButtons) {
		//if true, check if it's selected,
		if(singleRadio.isDisplayed() && singleRadio.isEnabled()) {
			//if false select the button
			if(singleRadio.isSelected()) {
				System.out.println("Radio button is Selected!");
			}else {
				System.out.println("Radio button is not selected");
				Thread.sleep(1000);
				singleRadio.click();
				}
			}else {
			System.out.println("Something is not right.Either not displayed or enabled");
		}
		Thread.sleep(1000);
		//check if it's selected, 
		System.out.println("Is radio button selected? " + singleRadio.isSelected());
	}
	}
public static void checkboxHomework() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//go to http://practice.primetech-apps.com/practice/check-box
	driver.get("http://practice.primetech-apps.com/practice/check-box");
	
	//find the checkboxes and verify if it's displayed
	List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[class=form-check-input"));
	//using for each loop to verify
	for(WebElement singleCheckbox : checkBoxes) {
		Thread.sleep(1000);
		if(singleCheckbox.isDisplayed()) {
			System.out.println("It's Dispalyed");
			//if true,verify if it's enabled
			if(singleCheckbox.isEnabled()) {
				System.out.println("It's enabled.");
				//if true,verify if it's selected
				if(singleCheckbox.isSelected()) {
					System.out.println("It's Selected");
				}else {
					System.out.println("It's not selected so, I am selecting it. Clicking");
					//if false, then check the boxes.
					singleCheckbox.click();
				}
			}else {
				System.out.println("It's not enabled");
			}
		
	}else {
		System.out.println("It's not Dispaled.");
	}
	//Then verify if it's checked.
	System.out.println("Is checkBox now selected? " + singleCheckbox.isSelected());
}
}
}
