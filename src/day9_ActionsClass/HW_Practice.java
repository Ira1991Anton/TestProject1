package day9_ActionsClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW_Practice {
	public static void main(String[] args) throws InterruptedException {
		dragdrop();
		iframeHomework();
	}

	public static void iframeHomework() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Test case 2:
		// go to http://practice.primetech-apps.com/practice/frames
		driver.get("http://practice.primetech-apps.com/practice/frames");
		// Verify that there is a page header text as "Frames".
		boolean isframetxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (isframetxt) {
			System.out.println("Frame text is there.");
		} else {
			System.out.println("Frame text is NOT there.");
		}

		// Find the iFrame element and switch into it
		driver.switchTo().frame("iframe1");
		// Find firstname, lastname, address, city, state, and zipcode, and type
		// relative information.
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Smith");
		driver.findElement(By.id("address")).sendKeys("1234 Main St");
		driver.findElement(By.id("city")).sendKeys("Fairfax");
		driver.findElement(By.id("zipCode")).sendKeys("12345");

		Select letsSelect = new Select(driver.findElement(By.id("state")));
		letsSelect.selectByVisibleText("Virginia");

		// driver.findElement(By.id("state")).sendKeys("Virginia");
		Thread.sleep(1000);

		// Click on submit button.
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		// Verify you see "You have submitted below information:" message.
		boolean infoText = driver.findElement(By.xpath("//h3[text()='You have submited below information:']"))
				.isDisplayed();
		if (infoText) {
			System.out.println("Info text is there.");
		} else {
			System.out.println("Info text is NOT there.");
		}
		// Switch back to main frame
		driver.switchTo().parentFrame();
		// Verify that there is a page header text as "Frames".
		boolean istxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (istxt) {
			System.out.println("Frame text is there.");
		} else {
			System.out.println("Frame text is NOT there.");
		}
	}
		
		public static void dragdrop() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			Actions letsdo = new Actions(driver);
			
			        // go to "http://practice.primetech-apps.com/practice/drag-and-drop"
			driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
					// Verify Drag And Drop text displays
			if (driver.findElement(By.xpath("//h3[text()='Drag And Drop']")).isDisplayed()) {
				System.out.println("Text is there.");
			}else {
				System.out.println("Text is not there.");
			}
					// drag the Text element to target window
			WebElement sourceText = driver.findElement(By.id("text"));
			WebElement targetZone = driver.findElement(By.id("dropzone"));
			
			letsdo.dragAndDrop(sourceText, targetZone).build().perform();
			Thread.sleep(1000);
					// drag the Textarea element to target window
			WebElement sourceTextArea = driver.findElement(By.id("textarea"));
			letsdo.dragAndDrop(sourceTextArea, targetZone).build().perform();
			Thread.sleep(1000);
					// drag the Number element to target window
			WebElement sourceNumber = driver.findElement(By.id("Number"));
			letsdo.dragAndDrop(sourceNumber, targetZone);
			Thread.sleep(1000);
					// delete all those dragged items from target window
			List<WebElement> removeButton = driver.findElements(By.cssSelector(".remove"));
			for (WebElement webElement : removeButton) {
				webElement.click();
				Thread.sleep(500);
			}
		}
		
	}

