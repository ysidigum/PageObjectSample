package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.BasePage;

public class OpenWebPage {

	BasePage bp = null;
	HomePage hm = null;
	
	@BeforeTest
	public void initialize() {
		bp = new BasePage();
		hm = new HomePage();
	}

	@SuppressWarnings("static-access")
	@Test
	public void openWebPage() {
		
		System.out.println(hm.getProp());
		hm.openUrl(hm.getProp().getProperty("url"));
		hm.clickSignInBtn();
		hm.getDriver().navigate().back();
		WebElement ele = hm.getDriver().findElement(By.xpath("//a[text()='Support']"));
		
		hm.mouseHover(ele);
	}

	@AfterTest
	public void tearDown() {
		bp.getDriver().close();
	}
}
