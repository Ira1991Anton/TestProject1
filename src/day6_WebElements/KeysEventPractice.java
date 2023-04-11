package day6_WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysEventPractice {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
	ClassPractice();
	AmazonPractice();
	listElement();
	elementStatus();
}
	public static void ClassPractice() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // waits for the page to be loaded.
		driver.manage().window().maximize();//maximize the page on which we are working 
		//driver.get("");
		driver.navigate().to("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Coffee Mug" + Keys.ENTER); // this opens a new page
		Thread.sleep(1000);
		//driver.findElement(By.name("q"));
		WebElement newSearchBox = driver.findElement(By.name("q"));
		newSearchBox.clear();
		Thread.sleep(1000);
		newSearchBox.sendKeys("Seleneium Webdriver" + Keys.ENTER); // 
		driver.navigate().back();
		driver.findElement(By.name("q")).clear(); 
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		driver.close();
}
public static void AmazonPractice() {
	//Test case 
			WebDriver driver = new ChromeDriver();
		    //maximize browser
			driver.manage().window().maximize();
		     //declare implicitly wait for 5 seconds
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     //go to amazon.com
			driver.get("https://amazon.com");
		     //Search coffee mug.
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug");
			driver.findElement(By.id("nav-search-submit-button")).click();
		     //Navigate back then search pretty coffee mug. 
			driver.navigate().back();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Pretty Coffee mug");
			driver.findElement(By.id("nav-search-submit-button")).click();
		     //Navigate back then navigate forward
			driver.navigate().back();
			driver.navigate().forward();
		     //Refresh the page.
			driver.navigate().refresh();
}
public static void listElement() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//go to https://saucedemo.com
	driver.get("https://saucedemo.com");
	//log in with username = standard_user   password = secret_sauce
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	//find all the results and get them in a list, and print the size of the list.
	List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));
	int listSize = items.size();
	System.out.println(listSize);
	
	List<WebElement> itemPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
	for (int i = 0; i < itemPrices.size(); i++) {
		System.out.println(itemPrices.get(i).getText());
	}
}
public static void elementStatus() {
		
		//Test case 1.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //go to https://indeed.com
		driver.get("https://indeed.com");
        //check if the search fields are enabled and displayed.
		WebElement whatField = driver.findElement(By.id("text-input-what"));
		WebElement whereField = driver.findElement(By.id("text-input-where"));
		
		System.out.println(whatField.isEnabled());
		System.out.println(whatField.isDisplayed());
		
		System.out.println(whereField.isEnabled());
		System.out.println(whereField.isDisplayed());
		
		if (whatField.isEnabled() && whatField.isDisplayed()) {
			System.out.println("What field is enabled and displayed!");
		}else {
			System.out.println("What field is either not enabled or displayed!");
		}
		
		if (whereField.isEnabled() && whereField.isDisplayed()) {
			System.out.println("Where field is enabled and displayed!");
		}else {
			System.out.println("Where field is either not enabled or displayed!");
}
}
}