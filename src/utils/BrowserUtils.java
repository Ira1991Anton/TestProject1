package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserUtils {
	
	WebDriverWait wait;
	JavascriptExecutor js;
	//this method clears the text of an given element
	public void clearText(WebElement element) {
		String temp = element.getAttribute("value");
		for(int i=0; i<temp.length(); i++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	
	public void waitForElementVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void scrollToElement(WebElement element) {
		js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);" ,element);
	}
	
	public void scrollDownByPixel(int number) {
		js =(JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scrollBy(0, " + number + ")");
	}
	public void highlightElement(WebElement element) throws InterruptedException {
		js =(JavascriptExecutor) Driver.getDriver();
		for (int i = 0; i < 3; i++) {
			js.executeScript("arguments[0].style.border='4px solid red'", element);
			Thread.sleep(1000);
		}
	}
}
