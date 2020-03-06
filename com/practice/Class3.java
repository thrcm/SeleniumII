package com.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
		
//		driver.get("http://166.62.36.207/syntaxpractice/index.html");
//		driver.manage().window().maximize();
//		
//		WebElement inputForms = driver.findElement(By.linkText("Input Forms"));
//		inputForms.click();
		
//		driver.findElement(By.linkText("Radio Buttons Demo")).click();
//		
//		List<WebElement> radioButtons=driver.findElements(By.xpath("//input[@name='optradio']"));
//		for(WebElement rb:radioButtons) {
//			String button=rb.getAttribute("value");
//			if(button.equalsIgnoreCase("male")) {
//				rb.click();
//			}
//		}
//		
		
//		driver.findElement(By.linkText("Select Dropdown List")).click();
//		WebElement dd = driver.findElement(By.id("select-demo"));
//		Select select = new Select(dd);
//		
//		List<WebElement> myList= select.getOptions();
//		for(WebElement ddList:myList) {
//			System.out.println(ddList.getText());
//		}
		
		
		
//		driver.findElement(By.linkText("Alerts & Modals")).click();
//		driver.findElement(By.linkText("Javascript Alerts")).click();
//		driver.navigate().refresh();
//		
//		driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']")).click();
//		
//		//alert box
//		Alert alert = driver.switchTo().alert();
//		String text = alert.getText();
//		System.out.println(text);
//		alert.accept();
		

//		driver.get("http://166.62.36.207/syntaxpractice/bootstrap-iframe.html");
//		driver.manage().window().maximize();
//		driver.switchTo().frame("FrameOne").findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/button")).click();
		

		driver.get("http://166.62.36.207/syntaxpractice/window-popup-modal-demo.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Instagram']"));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		//window handle
		Set<String> windowHandles=driver.getWindowHandles();
		int num = windowHandles.size();
		System.out.println("Number of windows open:" + num);
		
		Iterator<String> it = windowHandles.iterator();
		String firstW = it.next();
		String secW = it.next();
		
		driver.switchTo().window(secW);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}
