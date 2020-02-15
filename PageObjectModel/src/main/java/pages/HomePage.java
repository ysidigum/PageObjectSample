package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.BasePage;

public class HomePage extends BasePage{

	@FindBy(css = "a[data-app-link-cta='nav_sign_in']")
	public WebElement signIn;
	
	@FindBy(css = "ul[class='global-nav__menu clearfix'] a[data-app-link-cta='nav_apply_now']")
	public WebElement applyNow;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public SignInPage clickSignInBtn() {
		
		Assert.assertTrue(isDisplayed(signIn), "Sign In Btn Is Not Displayed");
		clickOnTheElement(signIn);
		
		return new SignInPage();
	}
	
}
