package class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.cssSelector("input[id*='txtUsername']")).sendKeys("VanEarl");
		Thread.sleep(5000);
		driver.findElement(By.id("txtPassword")).sendKeys("VanEarl@&12");
		Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
		
		//check if image is displayed - isDisplayed()
		WebElement logo = driver.findElement(By.cssSelector("img[src^='/humanresources/symfony/web/webres_5acde3dbd3adc6.90334155/the']"));
		if(logo.isDisplayed()) {
			System.out.println("logo is succesfully displayed");
		}else {
			System.err.println("logo IS NOT displayed!!!");
		}
		
		driver.quit();
				
				
	}
}
