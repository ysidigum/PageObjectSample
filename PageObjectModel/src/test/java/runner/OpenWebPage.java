package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.CustomTestNGReporter;

@Listeners(CustomTestNGReporter.class)
public class OpenWebPage {

	HomePage hm = null;
	
	@BeforeTest
	public void initialize() {
		hm = new HomePage();
	}

	@SuppressWarnings("static-access")
	@Test
	public void openWebPage() {
		
		hm.openUrl(hm.getProp().getProperty("url"));
		hm.clickSignInBtn();
		hm.hardSleep(3000);
		hm.getDriver().navigate().back();
		
		WebElement ele = hm.getDriver().findElement(By.xpath("//a[text()='Support']"));
		hm.mouseHover(ele);
	}

	@AfterTest
	public void tearDown() {
		hm.getDriver().close();
	}
}
