package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class FacebookPage {
	// page object model design is basically creating a class for a single application page 
		// and collect those web elements on that page to be reused
		// rather than finding the elements again and again when we need them.
	public FacebookPage() {

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(name = "email")
	public WebElement FBemailField;

	@FindBy(name = "pass")
	public WebElement FBpassField;

	@FindBy(name = "login")
	public WebElement FBloginBtn;

}
