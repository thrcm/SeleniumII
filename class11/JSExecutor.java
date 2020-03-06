package class11;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;
import utils.Constants;

public class JSExecutor extends utils.CommonMethods {
	/*
	 * JS Executor class is used when we cannnot perform actions using Selenium, which is Java based
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", utils.Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		
		//Downcast JS
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//using .executeScript() method
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].style.backgroundColor='green'", loginBtn);
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,22050)");
		Thread.sleep(5000);
		
		driver.quit();
	}
}

