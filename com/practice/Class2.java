package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MICROSECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");

		WebElement logo = driver.findElement(By.id("divLogo"));
		System.out.println(logo.isDisplayed());
		
		WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
		username.sendKeys("Admin");

		WebElement password = driver.findElement(By.cssSelector("input[name='txtPassword']"));
		password.sendKeys("Syntax@123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(3000);
		driver.close();
	}
}
