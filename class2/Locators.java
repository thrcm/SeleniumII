package class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hackerrank.com/auth/login?h_l=body_middle_left_button&h_r=login");
		
		WebElement userName = driver.findElement(By.id("input-1"));
		userName.sendKeys("atahircam@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("input-2")).sendKeys("Akademi105");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
}
