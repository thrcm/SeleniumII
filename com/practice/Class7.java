package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class7 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("http://166.62.36.207/syntaxpractice/table-search-filter-demo.html");
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-6 text-left']/h2")));
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("# of rows:"+rows.size());
		
		for(int i=0; i<rows.size(); i++) {
			String rowData = rows.get(i).getText();
			System.out.println(rowData);
		}
		
		System.out.println("\n\n*******");
		List<WebElement> cols= driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("# of columns: "+cols.size());
		
		for(WebElement colName:cols) {
			String name=colName.getText();
			System.out.println(name);
		}
		
		
		
		driver.quit();
	}
}
