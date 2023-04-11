package day8_PopUpWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window_Handles_PopUpWindowsOrTabs {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		windowHandlesExample();
	}
public static void newTabDemo() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver,5);
	
	driver.get("http://practice.primetech-apps.com/practice/browser-windows");
	String mainWindowId = driver.getWindowHandle();
	
	
}
public static void windowHandlesExample() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	//Test case 2 
	//go to http://practice.primetech-apps.com/practice/browser-windows
	driver.get("http://practice.primetech-apps.com/practice/browser-windows");
	//1. Get the main window ID and store it in a String called mainWindowId, 
	String mainWindowId = driver.getWindowHandle();
	//2. Click on the 'New Tab' button
	driver.findElement(By.id("newTab")).click();
	//3. Get window IDs and store it into a Set
	Set<String> windowIds = driver.getWindowHandles();
	//4. Get the first window ID from the Set 
	Iterator<String> iterate = windowIds.iterator();
	String firstWindowId = iterate.next();
	//Verify it matches with the main window id in step 1. 
	if (firstWindowId.equals(mainWindowId)) {
		System.out.println("First window id match the main window id.");
	}else {
		System.out.println("First window id does not match the main window id.");
	}
	//Then get the second window id and store it in variable called secondWindowId.
	String secondWindowId = iterate.next();
	//5. Switch to the second window
	driver.switchTo().window(secondWindowId);
	//6. Verify that there is a button called 'New Tab'
	if (driver.findElement(By.id("newTab")).isDisplayed()) {
		System.out.println("New tab button is available on the second window");
	}else {
		System.out.println("New tab button is not available on the second window");
	}
	//7. Close the window,   
	driver.close();
	//Switch back to the main window,
	driver.switchTo().window(mainWindowId);
	//Verify you are on the main window.
	if (driver.getWindowHandle().equals(mainWindowId)) {
		System.out.println("We are back to the main window.");
	}else {
		System.out.println("We are lost.");
	}
}
}

