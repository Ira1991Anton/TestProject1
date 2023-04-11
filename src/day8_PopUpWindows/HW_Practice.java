package day8_PopUpWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW_Practice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		//TestCase1();
		iframeHomework();
	}
public static void TestCase1() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	//go to http://demo.guru99.com/popup.php
	driver.get("http://demo.guru99.com/popup.php");
	//Get title and store it in a variable.
	String mainPageTitle = driver.getTitle();
	String mainPageWindowId = driver.getWindowHandle();
	 //Click on Click Here button and switch over to next window,provide an email click Submit. 
	driver.findElement(By.linkText("Click Here")).click();//by linkText found
	//We got the window ids from two tabs
	Set<String> windowIds = driver.getWindowHandles();//for each loop used here
	for(String str: windowIds) {
		if(!str.equals(mainPageWindowId)) {
			driver.switchTo().window(str);
		}
	}
	driver.findElement(By.name("emailid")).sendKeys("ana.pow@gmail.com");
	driver.findElement(By.name("btnLogin")).click();
	//Get text of the user ID and password and store them in variables, print them out.
	String userId = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
	// alternative xpath:
	// 1. //tr[4]//td[2] uses index 
	// 2. //td[text()='User ID :']//following-sibling::td uses sibling metod from brother to brother
	// 3. (//td[@align='center'])[3]
	// 4. //td[contains(text(), 'mngr')]uses first letters that are not chengable 
	
	String password = 
			driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText().trim();
	System.out.println("User id: " + userId);
	System.out.println("Password : " + password);
     //Then verify the text "This access is valid only for 20 days."
	String message = driver.findElement(By.xpath("//h3[contains(text(), 'This access')]")).getText();
	if (message.equals("This access is valid only for 20 days.")) {
		System.out.println("Test pass!");
	}else {
		System.out.println("Test fail!");
	}
     //Close the window.
	driver.close();
     //Go back to main window, and get title then verify it equals to your stored title.
	driver.switchTo().window(mainPageWindowId);
	if (driver.getTitle().equals(mainPageTitle)) {
		System.out.println("We are back to main page.");
	}else {
		System.out.println("We got lost.");
	}
     //Quit driver.
	driver.quit();
	

}
public static void iframeHomework() throws InterruptedException {

	WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
			//Test case 2: 
			//go to http://practice.primetech-apps.com/practice/frames
		driver.get("http://practice.primetech-apps.com/practice/frames");
			//Verify that there is a page header text as "Frames".
		boolean isframetxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (isframetxt) {
			System.out.println("Frame text is there.");
		}else {
			System.out.println("Frame text is NOT there.");
		}
		
			//Find the iFrame element and switch into it
		driver.switchTo().frame("iframe1");
			//Find firstname, lastname, address, city, state, and zipcode, and type relative information.
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Smith");
		driver.findElement(By.id("address")).sendKeys("1234 Main St");
		driver.findElement(By.id("city")).sendKeys("Fairfax");
		driver.findElement(By.id("zipCode")).sendKeys("12345");
		
		Select letsSelect = new Select(driver.findElement(By.id("state")));
		letsSelect.selectByVisibleText("Virginia");
		
		//driver.findElement(By.id("state")).sendKeys("Virginia");
		Thread.sleep(1000);
		
			//Click on submit button.
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
			//Verify you see "You have submitted below information:" message.
		boolean infoText = 
				driver.findElement(By.xpath("//h3[text()='You have submited below information:']")).isDisplayed();
		if (infoText) {
			System.out.println("Info text is there.");
		}else {
			System.out.println("Info text is NOT there.");
		}
			//Switch back to main frame
		driver.switchTo().parentFrame();
			//Verify that there is a page header text as "Frames".
		boolean istxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (istxt) {
			System.out.println("Frame text is there.");
		}else {
			System.out.println("Frame text is NOT there.");
		}
	}
}

