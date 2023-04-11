package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW_Practice {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
	  //amazonTest1();
		//amazonTest2();
		//alertsTest1();
		//alertsTest2();
		//alertsTest3();
		alerts4();
	}
public static void amazonTest1() {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//go to amazon.com 
	driver.get("http://amazon.com");
	//get all the options in the departments select DropDown.
	WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
	Select choose = new Select(selectElement);
	// verify there are total 58 departments. And print them out.
	List<WebElement> allOptions = choose.getOptions();
	System.out.println(allOptions.size());
	for(WebElement element : allOptions) {
		System.out.println(element.getText());
	}
	}
	
	public static void amazonTest2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// go to amazon.com
		driver.get("http://amazon.com");
	    // verify that you are on the amazon home page. (verify with title). 
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		if(driver.getTitle().equals(expectedTitle)) {
			System.out.println("We are on the Home Page: " + expectedTitle);
		}else {
			System.out.println("We are not on the Home Page.");
		}
		//verify dropdown value is by default "All Departments"
		String defaultDropdown = "All Departments";
		WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));
		
		Select choose = new Select(dropdownElement);
		
		String actualSelectedOption = choose.getFirstSelectedOption().getText();
		
		if(actualSelectedOption.equals(defaultDropdown)) {
			System.out.println("Default dropdown matches");
			}else {
				System.out.println("Default dropdown does not match");
			}
		//select department Home & Kitchen, and search coffee mug.
		 String searchItem = "Coffee Mug";
		 choose.selectByVisibleText("Home & Kitchen");
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
		 driver.findElement(By.id("nav-search-submit-button")).click();
	     //verify you are on coffee mug search results page (use title).
		 String itemPageTitle = driver.getTitle(); 
		 // Amazon.com : Coffee Mug 23 - 10 = 13
		 int beginningIndex = itemPageTitle.length() - searchItem.length();
		 
		 if (itemPageTitle.substring(beginningIndex).equals(searchItem)) {//we can use contins as well to do verification 
			System.out.println("Search item title match");
		}else {
			System.out.println("Search item title Does not match");
		}
	     //verify you are in Home & Kitchen department.
		 WebElement dropdown2 = driver.findElement(By.id("searchDropdownBox"));
		 Select choose2 = new Select(dropdown2);
		 String selectedOption = choose2.getFirstSelectedOption().getText();
		 if (selectedOption.equals("Home & Kitchen")) {
			System.out.println("Test pass.");
		}else {
			System.out.println("Test fail.");
		}
	}
		
	public static void alertsTest1() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	//go to http://practice.primetech-apps.com/practice/alerts
	driver.get("http://practice.primetech-apps.com/practice/alerts");
		//Click on the 'Alert'  button and Accept the alert. 
	driver.findElement(By.id("alert")).click();
	Alert handle = driver.switchTo().alert();
	Thread.sleep(1000);
	handle.accept();
}
public static void alertsTest2() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	//go to http://practice.primetech-apps.com/practice/alerts 
	driver.get("http://practice.primetech-apps.com/practice/alerts");
	//Click on the 'Confirm Alert' button and Get the text of it. 
	WebElement confirmButton = driver.findElement(By.id("confirm"));
	confirmButton.click();
	wait.until(ExpectedConditions.alertIsPresent());
	Alert handle  = driver.switchTo().alert();
	System.out.println(handle.getText());
	String text = "Do you wish to continue or cancel?";
	
	//Then verify if the text equals to "Do you wish to continue or cancel?" 
	String alertText = "Do you wish to continue or cancel?";
	if(alertText.equals(text)) {
		System.out.println("Text match with alert text, Test PASS " );
		//then Accept the alert.
		Thread.sleep(1000);
		handle.accept();
	}else {
		System.out.println("Text does not match with alert text.");
		//cancel the Alert
		Thread.sleep(1000);
		handle.dismiss();
	}
}
public static void alertsTest3() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	
	//go to http://practice.primetech-apps.com/practice/alerts 
	driver.get("http://practice.primetech-apps.com/practice/alerts ");
	//Click on the 'Prompt Alert' button and type PrimeTech
	 String text = "PrimeTech";
	 driver.findElement(By.id("prompt")).click();
	wait.until(ExpectedConditions.alertIsPresent());
	Alert handle = driver.switchTo().alert();
	handle.sendKeys(text);
    //Then accept the Alert. 
	handle.accept();
	//Verify that a greeting message displays as "Hello <your input>! How are you today?".
	WebElement greetingMessageElement = driver.findElement(By.id("demo"));
	wait.until(ExpectedConditions.visibilityOf(greetingMessageElement));
	String greetingText = greetingMessageElement.getText();
	if(greetingText.equals("Hello " + text + "! How are you today?")) {
		System.out.println("Test PAss!");
		
	}else {
		System.out.println("Test Fail");
	}
	
}
	
	public static void alerts4() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		//go to http://practice.primetech-apps.com/practice/alerts 
		driver.get("http://practice.primetech-apps.com/practice/alerts ");
		//Click on the 'Prompt Alert' button and type PrimeTech. Then dismiss the Alert.
		Thread.sleep(1000);
		String message = "PrimeTech";
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert handle = driver.switchTo().alert();
		Thread.sleep(1000);
		handle.sendKeys(message);
		Thread.sleep(1000);
		handle.dismiss();
		//Verify that "User cancelled the prompt." text displays.
		String userMessage = "User cancelled the prompt.";
		WebElement text = driver.findElement(By.id("demo"));
		wait.until(ExpectedConditions.visibilityOf(text));
		String alertText = text.getText();
		if(alertText.equals(userMessage)) {
			System.out.println("Text displayes, test PASSED");
		}else {
			System.out.println("Text does not displayes, Test FAIL");
		}
	}
}
	
