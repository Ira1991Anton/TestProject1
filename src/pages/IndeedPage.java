package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class IndeedPage {

	

	public IndeedPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	@FindBy (xpath = "//input[@id='text-input-where']")
	public WebElement whereField;
	
	@FindBy(id = "text-input-what")
	public WebElement whatField;
	
	@FindBy(xpath ="//button[text()='Search']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//a[text()= 'Upload your resume']")
	public WebElement uploadResumeLink;

	@FindBy(xpath = "//a[text()= 'Salaries']")
	public WebElement salaryLink;

	
}
