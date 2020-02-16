package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.helpers.LogLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static WebDriver driver = null; 
	private static WebDriverWait webDriverWait;
	private static long timeoutInSecs = Integer.parseInt(System.getProperty("timeOut"));
	private static LogLog log;
	private static Properties prop = null;
	private static InputStream input = null;


	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		BasePage.prop = prop;
	}


	public WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BasePage.driver = driver;
	}

	public static LogLog getLog() {
		return log;
	}

	public static void setLog(LogLog log) {
		BasePage.log = log;
	}



	static {
		try {
			setProp(new Properties());
			input = new FileInputStream("src/main/resource/testdata.properties");
			getProp().load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.setProperty("webdriver.chrome.driver", "/Users/ysidigum/Downloads/chromedriver");
		setDriver(new ChromeDriver());
		webDriverWait = new WebDriverWait(driver, timeoutInSecs);
		setLog(new LogLog());
		

	}

	/*
	 * Method to open the webpage URL
	 */
	@SuppressWarnings("static-access")
	public void openUrl(String url) {
		getLog().debug("Opening the web page: "+ url);
		driver.get(url);
		driver.manage().window().maximize();
	}

	/*
	 * Method used to check the explicit wait for the element condition
	 */
	@SuppressWarnings("static-access")
	private boolean explicitWaitForElement(WebElement ele) {
		boolean flag = false;
		try {
			webDriverWait.until(ExpectedConditions.visibilityOfAllElements(ele));
		}catch (Exception e) {
			getLog().error("Element is not found after: "+timeoutInSecs+" "+e.getMessage());
			flag = false;
		}

		return flag;
	}

	/*
	 * Click On The Web Element
	 */
	@SuppressWarnings("static-access")
	public void clickOnTheElement(WebElement ele) {
		try {
			explicitWaitForElement(ele);
			ele.click();
		}catch (Exception e) {
			getLog().error("Element is not found after: "+timeoutInSecs+" "+e.getMessage());
		}
	}

	/*
	 * Mouse Hover On The WebElement
	 */
	@SuppressWarnings("static-access")
	public void mouseHover(WebElement ele) {
		try {
			explicitWaitForElement(ele);
			Actions act = new Actions(getDriver());
			act.moveToElement(ele).perform();

		}catch (Exception e) {
			getLog().error("Mouse Hover On The Webelement Failed After: "+ timeoutInSecs +" "+e.getMessage());
		}
	}

	/*
	 * Check If The Web Element Is Displayed
	 */
	@SuppressWarnings("static-access")
	public boolean isDisplayed(WebElement ele) {
		boolean flag = false;
		try{
			explicitWaitForElement(ele);
			flag = true;
		}catch (Exception e) {
			getLog().error("Element is not displayed after: "+timeoutInSecs);
			flag = false;
		}

		return flag;
	}
	
	/*
	 * Milli Seconds 
	 */
	public void hardSleep(long milliSecs) {
		try {
			Thread.sleep(milliSecs);
		}catch (Exception e) {
		}
	}

}
