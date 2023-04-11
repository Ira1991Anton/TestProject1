package day10_FrameworkDesign;



import org.openqa.selenium.By;

import pages.FacebookPage;
import utils.DataReader;
import utils.Driver;


public class ReusableObjects {
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		ReusableObjects obj = new ReusableObjects();
		obj.testcase1();
		obj.testcase2();
		obj.getTextPractice();

	}
	FacebookPage fbPage;


	public void testcase1() {
		fbPage = new FacebookPage();
	     // go to facebook.com
		Driver.getDriver().get(DataReader.getProperty("testingUrl"));
	     // find the Email or phone number field and type Automation
		fbPage.FBemailField.sendKeys(DataReader.getProperty("facebookUsername"));
			
	     // find the Password field and type Automation
			fbPage.FBpassField.sendKeys(DataReader.getProperty("facebookPassword"));
	     // find the Login button and click on it.
			fbPage.FBloginBtn.click();
			Driver.quitDriver();
		}
		
		public void testcase2() throws InterruptedException {
			
		 //  go to facebook.com
			Driver.getDriver().get(DataReader.getProperty("testingUrl"));
		 // find the Create New Account button and click on it
			Driver.getDriver().findElement(By.linkText("Create new account")).click();
			
		 // find the FirstName,  LastName, Email and Password fields and type Automation
			Driver.getDriver().findElement(By.name("firstname")).sendKeys("automation");
			Driver.getDriver().findElement(By.name("lastname")).sendKeys("automation");
			Driver.getDriver().findElement(By.name("reg_email__")).sendKeys("automation");
			Driver.getDriver().findElement(By.name("reg_passwd__")).sendKeys("automation");
		 // find the Sign Up button and click on it.
			Driver.getDriver().findElement(By.name("websubmit")).click();
			Driver.quitDriver();
		}
		
		public void getTextPractice() {
		
			 //  go to facebook.com
			Driver.getDriver().get(DataReader.getProperty("testingUrl"));
			 // find the Login button and get text of it
				String loginText = Driver.getDriver().findElement(By.name("login")).getText();
				System.out.println("Log in button text is: " + loginText);
			 // verify that it is Log In
				if (loginText.equals("Log In")) {
					System.out.println("Test Pass!");
				} else {
					System.out.println("Test Fail! Text doesn't equal");
				}
				Driver.quitDriver();
		
	}
}
	


