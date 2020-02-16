package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignInPage extends HomePage{

	@FindBy(css="input[id='EmailAddress_inner']")
	private WebElement emailAddress;
	
	public SignInPage() {
		Assert.assertTrue(isDisplayed(emailAddress), "Email Address Field On Sign In Page");
	}
}
