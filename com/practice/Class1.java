package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.google.com/search?q=gmail&rlz=1C1CHBF_enUS881US881&oq=gmail&aqs=chrome..69i57j69i59j35i39j0l3j69i61l2.1484j0j7&sourceid=chrome&ie=UTF-8");
		driver.navigate().refresh();
		System.out.println("Title: "+title);
		
		driver.navigate().back();
		driver.navigate().forward();
		
		
		driver.close();
		//driver.quit();
		
	}
}
