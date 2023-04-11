package day3_advancedLocators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EtsyHW {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		EtsyHW etsy = new EtsyHW ();
		etsy.testcase1();
		etsy.testcase2();
	}
	public void testcase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//Go to etsy.com
		//Find Sign in button and click on it
		//Find email address field and type "automation"
		//Find the password field and type "automation"
		//Find the sign in button and click on it
		driver.get("https://www.etsy.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(2000);
	    driver.findElement(By.name("email")).sendKeys("automation");
	   driver.findElement(By.name("password")).sendKeys("automation");
		driver.findElement(By.name("submit_attempt")).click();
		driver.quit();
		
		}
	public void testcase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String searchCriteria = "SDET";
		//go to indeed.com
		driver.get("https://indeed.com");
		Thread.sleep(1000);
		//get the current URL and store it in a variable called homeURL.
		String homeURL = driver.getCurrentUrl();
		System.out.println("Home Page URL: " + homeURL);
		//get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
		System.out.println("Home Page Title: " + homeTitle);
		//find the input field for WHAT and type SDET
		driver.findElement(By.id("text-input-what")).sendKeys(searchCriteria);
		//find the input field for where, clear the field first and type washington DC
		//find the Find Jobs button and click on it.
		driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
		Thread.sleep(1000);
		//get the current URL and store it a variable searchURL.
		String searchURL = driver.getCurrentUrl();
		System.out.println("Search Page URL: " + searchURL);
		//get the website title and store it in a variable searchTitle.
		String searchTitle = driver.getTitle().toUpperCase();
		System.out.println("Search Page Title: " + searchTitle);
		//verify that searchURL does not equal to homeURL and contains the search criteria.
		if (!searchURL.equals(homeURL) && searchURL.contains(searchCriteria)) {
			System.out.println("Search URL doesn't match and contains the search criteria. Test Pass!");
		} else {
			System.out.println("Search URL matches or doesn't contain the search Criteria. Test Fail!");
		}
		//verify that searchTitle does not equal to homeTitle and has the search criteria.
		if (!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {
			System.out.println("Search Title doesn't match and contains the search criteria. Test Pass!");
		} else {
			System.out.println("Search Title matches or doesn't contain the search Criteria. Test Fail!");
		}
		//Get Text of the JobsInLocation field, store it in a variable, then verify if it's equals to your search criteria. 
        String jobsInLocationText = driver.findElement(By.className("jobsearch-SerpTitle")).getText();
        System.out.println("Jobs in the Location text: " + jobsInLocationText);
        
        if (jobsInLocationText.contains(searchCriteria)) {
			System.out.println("Jobs in Location Text Contains the Search Criteria. Test Pass!");
		} else {
			System.out.println("Jobs in Location Text Does not Contain the Search Criteria. Test Fail!");
		}
        
        String searchCriteriaSubText = jobsInLocationText.substring(0, searchCriteria.length());
        
        System.out.println(searchCriteriaSubText + " " + searchCriteria.length());
        
        if (searchCriteriaSubText.equals(searchCriteria)) {
			System.out.println("Jobs in Location Text Equals the Search Criteria. Test Pass!");
		} else {
			System.out.println("Jobs in Location Text Does not Contain the Search Criteria. Test Fail!");
		}
        
	}
	}

