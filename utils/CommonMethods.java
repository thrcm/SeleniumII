package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	
	public static WebDriver driver;
	
	/**
	 * Use this parameter in need of...
	 * @param browser preferred Internet browser
	 * @param url	  URL of destination
	 * @return
	 * @throws InterruptedException
	 */
	public static WebDriver setUp(String browser, String url) throws InterruptedException {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//maximize-minimize page
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	/**
	 * This method accepts alert
	 * @throws throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present.");
		}
	}
	
	/**
	 * This method dismisses alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert is not present.");
		}
	}
	
	
	/**
	 * This method gets a text from alert
	 * @return text of the alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	
	public static String getTextFromAlert() {
		String textAlert;
		try {
			Alert alert = driver.switchTo().alert();
			textAlert = alert.getText();
		}catch(NoAlertPresentException e) {
			textAlert="Alert is not present.";
		}
		return textAlert;
	}
	
	/**
	 * This method will switch the frame
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present.");
		}
	}
	
	
	/**
	 * This method will switch the frame
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present.");
		}
	}
	
	/**
	 * This method will switch the frame
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
