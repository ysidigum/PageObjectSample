package utilities;

import org.apache.log4j.helpers.LogLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SingleTonBasePage {
	
	// static variable single_instance of type Singleton 
	private static SingleTonBasePage single_instance = null; 
	private static WebDriver driver = null; 
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SingleTonBasePage.driver = driver;
	}

	private static WebDriverWait webDriverWait;
	private static long timeoutInSecs = Integer.parseInt(System.getProperty("timeOut"));
	private static LogLog log;

	// private constructor restricted to this class itself 
	private SingleTonBasePage() { 
	} 

	// static method to create instance of Singleton class 
	public static SingleTonBasePage getInstance() 
	{ 
		if (single_instance == null && driver == null) { 
			single_instance = new SingleTonBasePage(); 
			System.setProperty("webdriver.chrome.driver", "/Users/ysidigum/Downloads/chromedriver");
			driver = new ChromeDriver();
			webDriverWait = new WebDriverWait(driver, timeoutInSecs);
			log = new LogLog();
		}
		return single_instance; 
	}
	
	/*
	 * Method to open the webpage URL
	 */
	@SuppressWarnings("static-access")
	public void openUrl(String url) {
		log.debug("Opening the web page: "+ url);
		driver.get(url);
	}

	/*
	 * Method used to check the explicit wait for the element condition
	 */
	@SuppressWarnings("static-access")
	private boolean explicitWaitForElement(WebElement ele) {
		boolean flag = false;
		try {
			System.out.println("Executing Wait For Element Visibility: "+timeoutInSecs);
			webDriverWait.until(ExpectedConditions.visibilityOfAllElements(ele));
		}catch (Exception e) {
			log.error("Element is not found after: "+timeoutInSecs+" "+e.getMessage());
			flag = false;
		}

		return flag;
	}
	
	@SuppressWarnings("static-access")
	public void clickOnTheElement(WebElement ele) {
		try {
			explicitWaitForElement(ele);
			ele.click();
		}catch (Exception e) {
			log.error("Element is not found after: "+timeoutInSecs+" "+e.getMessage());
		}
	}
	
} 