package day10_FrameworkDesign;

import org.openqa.selenium.JavascriptExecutor;

import pages.IndeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class JsExecutorDemo {
public static void main(String[] args) throws InterruptedException {
	
	IndeedPage indeedPage = new IndeedPage();
	BrowserUtils utils = new BrowserUtils();
	Driver.getDriver().get(DataReader.getProperty("indeedUrl"));
	utils.highlightElement(indeedPage.whatField);
	indeedPage.whatField.sendKeys("software test engineer");
	utils.highlightElement(indeedPage.searchBtn);
    indeedPage.searchBtn.click();
    Thread.sleep(3000);
    utils.scrollDownByPixel(1500);
	
	
}
}
