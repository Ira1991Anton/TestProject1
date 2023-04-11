package day5_Xpath_contains_CSS_selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_xpath_Css_Locators {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "/Users/irina/Desktop/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
	PrimeTechApp();
}
public static void PrimeTechApp() throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	//1. Go to http://practice.primetech-apps.com/practice/web-tables
driver.get("http://practice.primetech-apps.com/practice/web-tables");


//2. Verify that you see Web Table's text
		String webtabelHeaderText = driver.findElement(By.xpath("//h3[text()='Web Tables']")).getText();
		if (webtabelHeaderText.equals("Web Tables")) {
			System.out.println(" We are on the Web Table Page.");
		}else {
			System.out.println("We are not on the Web table Page.");
		}
		//3. Find id, firstname, lastname, salary fields and give a relevant input. (store the information into variables, then pass the variable to sendKeys() method) 
		int id = 678;
		String firstname = "Mark";
		String lastname = "Pow";
	    int salary = 120000;
	    //double salary2 = 13000.00;
		
	    driver.findElement(By.cssSelector("input[id=Id]")).sendKeys(String.valueOf(id));
	    driver.findElement(By.cssSelector("input[id='First Name']")).sendKeys(firstname);
	    driver.findElement(By.cssSelector("input[id='Last Name']")).sendKeys(lastname);
	    driver.findElement(By.cssSelector("input[id='Salary']")).sendKeys(String.valueOf(salary));
	    Thread.sleep(1000);
	  //4. Click on Add button
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(1000);
	    
	    
		//5. Then your inputs will display under the table. (use xpath text() contains() functions to locate those elements. get text and store them into variables)
		String actualId = driver.findElement(By.xpath("//td[text()='" + id + "']")).getText(); //we did dynamic id
		System.out.println(actualId);
		String actualFirstname = driver.findElement(By.xpath("//td[text()='" + firstname + "']")).getText();//we did dynamic firstName
		System.out.println(actualFirstname);
		String actualLastname = driver.findElement(By.xpath("//td[text()='" + lastname + "']")).getText();//we did dynamic lastName
		System.out.println(actualLastname);
		String actualSalary = driver.findElement(By.xpath("//td[text()='" + salary + "']")).getText();//we did dynamic salary
		System.out.println(actualSalary);
	    //6. Verify your input under the table match the input you added. 
		
		
		if (Integer.parseInt(actualId) == id) {
			System.out.println("ID is good, Test Pass!");
		} else {
			System.out.println("ID is not good.");
		}
		if (actualFirstname.equals(firstname)) {
			System.out.println("Firstname is good, Test Pass!");
		} else {
			System.out.println("Firstname is not good.");
		}
		if (actualLastname.equals(lastname)) {
			System.out.println("Lastname is good, Test Pass!");
		} else {
			System.out.println("Lastname is not good.");
		}
		if (Integer.parseInt(actualSalary) == salary) {
			System.out.println("Salary is good, Test Pass!");
		} else {
			System.out.println("Salary is not good.");
		}

}
}
